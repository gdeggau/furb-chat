import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConfigs } from 'src/app/commons/app-configs';
import { Observable } from 'rxjs';

@Injectable()
export class GrupoService {
    constructor(public http: HttpClient) {
    }

    getGrupo(id: number): Observable<any> {
        return this.http.get(AppConfigs.API_ENDPOINT + '/grupos/' + id);
    }

    getConversaGrupo(id: number): Observable<any> {
        return this.http.get(AppConfigs.API_ENDPOINT + '/mensagens/grupo/' + id);
    }

    postContatosGrupo(idGrupo: number, contatosSelecionados: any) {
        let body = {
            idGrupo: {
                idGrupo: idGrupo
            }
        }
        contatosSelecionados.forEach(idUsuarioContato => {
            this.http.post(AppConfigs.API_ENDPOINT + '/grupos/usuarios/' + idUsuarioContato, body).
            subscribe(res => {
                console.log(res);
            }, error => {
                console.log(error);
            });
        });
    }

    postMensagemTexto(mensagem: any, idGrupo: number) {
        let body = {
            dsMensagem: mensagem.dsMensagem,
            idUsuarioEnvio: mensagem.idUsuarioEnvio
        }
        this.http.post(AppConfigs.API_ENDPOINT + '/mensagens/grupo/' + idGrupo, body).
        subscribe(res => {
            console.log(res);
        }, error => {
            console.log(error);
        });
    }
}
