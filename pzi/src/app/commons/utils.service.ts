import { Injectable } from '@angular/core';
import { HttpHeaders } from '@angular/common/http';

@Injectable()
export class UtilsService {

  constructor() {}

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

  getIdUsuarioLogado(): number {
    return 1;
  }

}
