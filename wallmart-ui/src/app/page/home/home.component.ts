import { Component, OnInit } from '@angular/core';
import { IPage, IPageable } from 'src/app/interface/http.interface';
import { AppService } from 'src/app/service/app.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  private pageable : IPageable = {} as IPageable;
  public dataProduct: IPage = {} as IPage;

  constructor(public appService: AppService) {
    // Default values
    this.pageable.page  = 0;
    this.pageable.size  = 10;
    this.pageable.order = 'id';
    this.pageable.asc   = true;

    
  }

  ngOnInit(): void {
    
  }

}
