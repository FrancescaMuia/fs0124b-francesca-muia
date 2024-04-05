import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [{ path: 'auth', loadChildren: () => import('./auth/auth.module').then(m => m.AuthModule) }, { path: 'film', loadChildren: () => import('./film/film.module').then(m => m.FilmModule) }, { path: 'film', loadChildren: () => import('./pages/film/film.module').then(m => m.FilmModule) }, { path: 'user', loadChildren: () => import('./pages/user/user.module').then(m => m.UserModule) }, { path: 'registrati', loadChildren: () => import('./pages/registrati/registrati.module').then(m => m.RegistratiModule) }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
