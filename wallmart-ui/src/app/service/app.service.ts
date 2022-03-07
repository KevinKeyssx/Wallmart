import { Injectable }                         from '@angular/core';
import { HttpClient }                         from '@angular/common/http';
import { BehaviorSubject, map, Observable }   from 'rxjs';
import { IMap, IPage, IPageable, IRequest }              from '../interface/http.interface';
import { environment }                        from 'src/environments/environment';
import { Constants }                          from '../util/constants';
import { IProduct }                           from '../interface/product.interface';

@Injectable({
  providedIn: 'root'
})
export class AppService {

  private isLoadingProductData  = new BehaviorSubject<boolean>(false);
  public isLoadingProductData$  = this.isLoadingProductData.asObservable();
  private productData           = {} as IPage;

  constructor(private http: HttpClient) { }

  public setProducts$(pageable? : IPageable): Observable<object> | null {
    console.log('Get Products...');
    return this.sendRequestApi$({
      verb  : 'GET',
      url   : environment.URL_LOCALHOST + Constants.END_PRODUCT_SEARCHALL,
      params : [
        { key: 'page',   value: pageable ? pageable.page : 0 }, 
        { key: 'size',   value: pageable ? pageable.size : 10 }, 
        { key: 'order',  value: pageable ? pageable.order: 'id' }, 
        { key: 'asc',    value: pageable ? pageable.asc: true }]
    })!
    .pipe(map((response: any) => {
        this.productData = response;
        this.isLoadingProductData.next(true);
        console.log('DATA:', response);
        return response;
      })
    );
  }

  public getProducts(): IProduct[] {
    return this.productData.content;
  }

  public getProductData(): IPage {
    return this.productData;
  }

  public sendRequestApi$(requestData: IRequest): Observable<object> | undefined {
    return {
      'GET'     : this.http.get<object>(requestData.url + this.createParams(requestData.params!)),
    }[requestData.verb];
  }

  private createParams(querys: IMap[]): string {
    let params = new URLSearchParams();
    if (!querys) {
      return ''
    }
    for (const query of querys) {
      params.set(query.key, query.value);
    }
    return '?' + params.toString();
  }
}
