import { Component }            from '@angular/core';
import { AppService }           from 'src/app/service/app.service';

@Component({
  selector        : 'app-card',
  templateUrl     : './card.component.html',
  styleUrls       : ['./card.component.styl']
})
export class CardComponent {

  constructor(public appService: AppService) { }

  public addPoint(value: number): string {
    return value.toLocaleString();
  }

  public isPalindrome(value: string): boolean {
    return value.split("").reverse().join("") === value;
  }

  public realPrice(value: number): number {
    return value * 2;
  }

}
