import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './componenti/navbar/navbar.component';
import { HomeComponent } from './pages/home/home.component';
import { ActivePostComponent } from './pages/active-post/active-post.component';
import { InactivePostComponent } from './pages/inactive-post/inactive-post.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    ActivePostComponent,
    InactivePostComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
