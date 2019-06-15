import { HttpClient } from '@angular/common/http';
import { AppConfigs } from 'src/app/commons/app-configs';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable()
export class LoginService {
    constructor(public http: HttpClient) {
    }

    getUsuarioLogin(usuario: any): Observable<any> {
        return this.http.get(AppConfigs.API_ENDPOINT + '/usuarios/' + usuario.nrTelefone + '/' + usuario.dsSenha);
    }
}