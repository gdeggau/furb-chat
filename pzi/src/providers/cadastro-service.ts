import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConfigs } from 'src/app/commons/app-configs';

@Injectable()
export class CadastroService {
    constructor(public http : HttpClient) {
    }

    postUsuario(usuario: any) {
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
        subscribe(res => {
            console.log(res);
        }, error => {
            console.log(error);
        });
    }
}
