import { Injectable } from '@angular/core';
import { HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';

@Injectable()
export class UtilsService {

  constructor(public router: Router) {}

  formatarDataServico(data: String) {
    const datas = data.split('/');
    return `${datas[2]}-${datas[1]}-${datas[0]}`;
  }

  getDefaultHeaders(): HttpHeaders {
    const headers = new HttpHeaders();
    headers.append('Accept', 'application/json');
    headers.append('Content-Type', 'application/json');
    return headers;
  }

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
