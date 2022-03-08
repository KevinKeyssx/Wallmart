import { Component, OnInit } from '@angular/core';
import { IPage, IPageable } from 'src/app/interface/http.interface';
import { AppService } from 'src/app/service/app.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  public dataProduct: IPage = {} as IPage;
  public data: IPageable = {} as IPageable;

  constructor(public appService: AppService) { }

  ngOnInit(): void { }

  public getPageable(value: IPageable) {
    this.data = value;
    console.log('EVENT OUTPUT:', this.data);
  }

}
