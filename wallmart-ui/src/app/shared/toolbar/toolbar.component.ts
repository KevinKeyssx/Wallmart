import { Component, OnInit }    from '@angular/core';
import { IPageable }            from 'src/app/interface/http.interface';
import { AppService }           from 'src/app/service/app.service';

@Component({
  selector      : 'app-toolbar',
  templateUrl   : './toolbar.component.html',
  styleUrls     : ['./toolbar.component.scss']
})
export class ToolbarComponent implements OnInit {

  constructor(private appService: AppService) { 
    this.appService.product = '';
  }

  ngOnInit(): void {
    this.findProduct(this.appService.paginator, 'product/search', '');
  }

  public searchProduct(event: any): void {
    this.appService.product = event.target.value;
    if (event.target.value === '') {
      this.findProduct(this.appService.paginator, 'product/search', event.target.value);
    }
    else if (!isNaN(Number(event.target.value))) {
      this.findProduct(this.appService.paginator,'product/search', event.target.value);
    }
    else if (event.target.value.toString().length > 2) {
      this.findProduct(this.appService.paginator,'product/search', event.target.value);
    }
  }

  private findProduct(data: IPageable, endpoint: string, event: any): void {
    this.appService.setProducts$(data, endpoint, event)!
      .subscribe({
        next: (response: any) => {
          console.log('Buscar Producto:', response);
        },error: () => {
        }
      }
    );
  }

}
