import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AppConfigs } from 'src/app/commons/app-configs';
import { Injectable } from '@angular/core';
import { UtilsService } from 'src/app/commons/utils.service';

@Injectable()
export class ConversaService {
    constructor(public http: HttpClient,
                public utils: UtilsService) {
    }

    getConversa(idUsuarioDestino: number): Observable<any> {
        return this.http.get(AppConfigs.API_ENDPOINT + '/mensagens/usuario/' + this.utils.getIdUsuarioLogado() + '/' + idUsuarioDestino);
    }

    postMensagemTexto(mensagem: any, idUsuarioDestino: number) {
        let body = {
            dsMensagem: mensagem.dsMensagem,
            idUsuarioEnvio: mensagem.idUsuarioEnvio
        }
        this.http.post(AppConfigs.API_ENDPOINT + '/mensagens/usuario/' + idUsuarioDestino, body).
        subscribe(res => {
            console.log(res);
        }, error => {
            console.log(error);
        });
    }

    getUsuarioConversa(id: number): Observable<any> {
        return this.http.get(AppConfigs.API_ENDPOINT + '/usuarios/' + id);
    }
}
