import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { AppConfigs } from 'src/app/commons/app-configs';

@Injectable()
export class ContatosService {
    constructor(public http : HttpClient) {
    }

    getContatos(id: number): Observable<any> {
        return this.http.get(AppConfigs.API_ENDPOINT + '/contatos/' + id);
    }

    postContato(telefone: string, usuario: any) {
        this.http.post(AppConfigs.API_ENDPOINT + '/contatos/' + telefone, usuario).
        subscribe(contato => {
            console.log(contato);
        }, error => {
            console.log(error);
        });
    }

    postGrupo(nome: string, usuario: any) {
        let body = {
            nmGrupo: nome,
            idUsuarioCadastro: usuario
        }
        this.http.post(AppConfigs.API_ENDPOINT + '/grupos', body).
        subscribe(grupo => {
            console.log(grupo);
        }, error => {
            console.log(error);
        });
    }
}
