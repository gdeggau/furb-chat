import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConfigs } from 'src/app/commons/app-configs';
import { UtilsService } from 'src/app/commons/utils.service';

@Injectable()
export class CadastroService {
    constructor(public http : HttpClient,
                public utils: UtilsService) {
    }

    postUsuario(usuario: any) {
        /*const httpOptions = {
            headers: this.utils.getDefaultHeaders()
        };
        let usu = JSON.stringify(usuario);*/
        let body = {
            nmUsuario: usuario.nmUsuario,
            nmExibicao: usuario.nmExibicao,
            dtNascimento: usuario.dtNascimento,
            nrTelefone: usuario.nrTelefone,
            dsEmail: usuario.dsEmail,
            dsSenha: usuario.dsSenha,
            dsCaminhoFoto: usuario.dsCaminhoFoto,
            dsFrasePerfil: usuario.dsFrasePerfil,
            flStatus: 'D'
        }
        this.http.post(AppConfigs.API_ENDPOINT + '/usuarios', body).
        //this.http.post(AppConfigs.API_ENDPOINT + '/usuarios', usu, httpOptions).
        subscribe(res => {
            console.log(res);
        }, error => {
            console.log(error);
        });
    }
}
