import { NgModule }             from '@angular/core';
import { MatPaginatorModule }   from '@angular/material/paginator';
import { MatToolbarModule }     from '@angular/material/toolbar';
import { MatIconModule }        from '@angular/material/icon';
import { MatInputModule }       from '@angular/material/input';
import { MatSelectModule }      from '@angular/material/select';
import { MatCheckboxModule }    from '@angular/material/checkbox';

const MaterialComponents = [
  MatPaginatorModule,
  MatToolbarModule,
  MatIconModule,
  MatInputModule,
  MatSelectModule,
  MatCheckboxModule
];

@NgModule({
  declarations  : [],
  imports       : [MaterialComponents],
  exports       : [MaterialComponents],

})
export class MaterialModule { }
