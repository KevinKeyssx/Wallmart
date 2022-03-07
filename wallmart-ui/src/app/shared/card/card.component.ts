import { Component, OnInit, Input }     from '@angular/core';
import { IPage }                        from 'src/app/interface/http.interface';
import { AppService } from 'src/app/service/app.service';

@Component({
  selector        : 'app-card',
  templateUrl     : './card.component.html',
  styleUrls       : ['./card.component.styl']
})
export class CardComponent implements OnInit {

  public dataPage: IPage = {} as IPage;

  constructor(private appService: AppService) {
    this.appService.setProducts$()!.subscribe((response: any) => {
      this.dataPage = response
      console.log('CARD DATA:', response);
    });
  }

  ngOnInit(): void {
    
  }

}
6