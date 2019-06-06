import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConfigs } from 'src/app/commons/app-configs';

@Injectable()
export class CadastroService {
    constructor(public http : HttpClient) {
    }

    postUsuario() {
        var headers = new Headers();
        headers.append('Accept', 'application/json');
        headers.append('Content-Type', 'application/json');
        //let options = new RequestOptions({ headers: headers });
        let params = {
            nmUsuario: 'Teste',
            nmExibicao: 'Teste',
            //dtNascimento: '',
            nrTelefone: '1234567890',
            dsEmail: 'teste@pzi.com',
            dsSenha: '',
            //dsCaminhoFoto: '',
            dsFrasePerfil: 'Frase de teste',
            flStatus: 'D',
            flAtivo: 'A'
        }
        this.http.post(AppConfigs.API_ENDPOINT, params);
    }
}
