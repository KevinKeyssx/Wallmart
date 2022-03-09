import { Component, Injectable}       from '@angular/core';
import { PageEvent }                  from '@angular/material/paginator';
import { IPageable }                  from 'src/app/interface/http.interface';
import { AppService }                 from 'src/app/service/app.service';

@Component({
  selector      : 'app-paginator',
  templateUrl   : './paginator.component.html',
  styleUrls     : ['./paginator.component.scss']
})

@Injectable()
export class PaginatorComponent {

  public order                = ['Id', 'Marca', 'Descripción', 'Precio'];
  public pageSizeOptions      = [5, 10, 25];
  public showFirstLastButtons = true;

  constructor(public appService: AppService) {
    // Default values
    this.appService.paginator.page    = 0;
    this.appService.paginator.size    = 10;
    this.appService.paginator.order   = 'id';
    this.appService.paginator.asc     = true;
    this.appService.paginator.length  = 3000;
  }

  handlePageEvent(event: PageEvent) {
    this.appService.paginator.length = event.length;
    this.appService.paginator.size = event.pageSize;
    this.appService.paginator.page = event.pageIndex;
    this.findProduct(this.appService.paginator, this.appService.product);
  }

  private findProduct(data: IPageable, event: any): void {
    this.appService.setProducts$(data, event)!
      .subscribe({
        next: () => {
          console.log('Buscar Producto');
        },error: () => {
        }
      }
    );
  }

  public onChange(event: any){
    this.appService.paginator.order = this.getType(event.target.value);
    this.findProduct(this.appService.paginator, this.appService.product);
  }

  public onCheck(event: any): void {
    this.appService.paginator.asc = event.checked;
    this.findProduct(this.appService.paginator, this.appService.product);
  }

  private getType(type: string): string {
    return {
      'Id'            : 'id',
      'Marca'         : 'brand',
      'Descripción'   : 'description',
      'Precio'        : 'price'
    }[type] || 'id';
  }

}
