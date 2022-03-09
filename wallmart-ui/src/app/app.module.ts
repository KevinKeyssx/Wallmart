import { NgModule }                             from '@angular/core';
import { BrowserModule }                        from '@angular/platform-browser';
import { HttpClientModule }                     from '@angular/common/http';
import { AppRoutingModule }                     from './app-routing.module';
import { AppComponent }                         from './app.component';

import { HomeComponent }                        from './page/home/home.component';
import { BrowserAnimationsModule }              from '@angular/platform-browser/animations';
import { CardComponent }                        from './shared/card/card.component';
import { MaterialModule }                       from './shared/material/material.module';
import { PaginatorComponent }                   from './shared/paginator/paginator.component';
import { ToolbarComponent }                     from './shared/toolbar/toolbar.component';
import { FooterComponent }                      from './shared/footer/footer.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    CardComponent,
    PaginatorComponent,
    ToolbarComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MaterialModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
