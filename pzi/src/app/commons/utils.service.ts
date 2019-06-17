import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable()
export class UtilsService {

  constructor(public router: Router) {}

  setUsuarioLogado(usuario: any) {
    localStorage.setItem('usuarioLogado', JSON.stringify(usuario));
  }

  getUsuarioLogado(): any {
    return JSON.parse(localStorage.getItem('usuarioLogado'));
  }

  verificarUsuarioLogado() {
    if (!this.getUsuarioLogado()) {
      this.router.navigate(['/login']);
    }
  }

}
