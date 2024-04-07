import { Injectable } from '@angular/core';
import {
  ActivatedRouteSnapshot,
  CanActivate,
  CanActivateChild,
  GuardResult,
  MaybeAsync,
  Router,
  RouterStateSnapshot,
} from '@angular/router';
import { AuthService } from './auth.service';
import { JwtHelperService } from '@auth0/angular-jwt';

@Injectable({
  providedIn: 'root',
})
export class AuthGuard implements CanActivate, CanActivateChild {
  jwtHelper: JwtHelperService = new JwtHelperService(); //ci permette di lavorare facilmente con i jwt

  constructor(
    private authSvc: AuthService,
    private router: Router //per i redirect
  ) {}

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ): boolean {
    if (localStorage.getItem('accessData')) {
      //controllo se esiste accessData nel localStorage
      const accessData = localStorage.getItem('accessData'); //mi salvo i dati dell'accessToken nella variabile in formato stringa
      const token = accessData ? JSON.parse(accessData) : false; //se c'è accessData lo trasformo in stringa, se non c'è ho false
      if (!token) {
        //se non ho i dati ritorna false
        this.router.navigate(['']); //reindirizzo l'utente al login se non è loggato
        return false;
      }
      const jwt = token.accessToken; //se ho i dati e quindi il token lo salvo nella const jwt
      const expDate = this.jwtHelper.getTokenExpirationDate(jwt) as Date; //salvo la data di scadena del token
      const now = new Date(); //salvo la data attuale
      if (now > expDate) {
        localStorage.removeItem('accessData'); //se data attuale supera quella di scadenza mi fa fare il logout
        this.router.navigate(['']);
        return false;
      }
      return true;
    }
    this.router.navigate(['']);
    return false; //se non esiste accessData nel localStorage
  }

  // canActivate(
  //   route: ActivatedRouteSnapshot,
  //   state: RouterStateSnapshot
  // ): MaybeAsync<GuardResult> {
  //   if (!this.authSvc.syncIsLoggedIn) {
  //     this.router.navigate(['']);
  //   }

  //   return this.authSvc.syncIsLoggedIn;
  // }

  canActivateChild(
    childRoute: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ): MaybeAsync<GuardResult> {
    return this.canActivate(childRoute, state);
  }
}
