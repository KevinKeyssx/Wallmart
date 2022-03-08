import { NgModule }             from '@angular/core';
import { MatChipsModule }       from '@angular/material/chips';
import { MatButtonModule }      from '@angular/material/button';
import { MatPaginatorModule }   from '@angular/material/paginator';
import { MatToolbarModule }     from '@angular/material/toolbar';
import { MatIconModule }        from '@angular/material/icon';
import { MatInputModule }       from '@angular/material/input';
import { MatFormFieldModule }   from '@angular/material/form-field';
import { MatSelectModule }      from '@angular/material/select';
import { MatCheckboxModule }    from '@angular/material/checkbox';

const MaterialComponents = [
  MatChipsModule,
  MatButtonModule,
  MatPaginatorModule,
  MatToolbarModule,
  MatIconModule,
  MatInputModule,
  MatFormFieldModule,
  MatSelectModule,
  MatCheckboxModule
];

@NgModule({
  declarations  : [],
  imports       : [MaterialComponents],
  exports       : [MaterialComponents],

})
export class MaterialModule { }
