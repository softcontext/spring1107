import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { SanitizeHtmlPipe } from './pipe/sanitize-html.pipe';

import { ListComponent } from './board/list/list.component';
import { WriteComponent } from './board/write/write.component';
import { UpdateComponent } from './board/update/update.component';
import { ViewComponent } from './board/view/view.component';

@NgModule({
  declarations: [
    AppComponent,
    SanitizeHtmlPipe,
    ListComponent,
    WriteComponent,
    UpdateComponent,
    ViewComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule, ReactiveFormsModule,
    RouterModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
