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
    this.findProduct();
  }

  public searchProduct(event: any): void {
    this.appService.product = event.target.value;
    if (event.target.value === '') {
      this.appService.paginator.length = 3000;
      this.findProduct(this.appService.paginator, event.target.value);
    }
    else if (!isNaN(Number(event.target.value))) {
      this.appService.paginator.length = 1;
      this.findProduct(this.appService.paginator, event.target.value);
    }
    else if (event.target.value.toString().length > 2) {
      this.appService.paginator.length = 3000;
      this.findProduct(this.appService.paginator, event.target.value);
    }
  }

  private findProduct(data?: IPageable, value?: string): void {
    this.appService.setProducts$(data, value)!
      .subscribe({
        next: (response: any) => {
          console.log('Buscar Producto:', response);
        },error: () => {
        }
      }
    );
  }

}
