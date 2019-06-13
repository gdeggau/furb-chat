import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AppConfigs } from 'src/app/commons/app-configs';
import { Injectable } from '@angular/core';

@Injectable()
export class ConversaService {
    constructor(public http: HttpClient) {
    }

    getConversa(): Observable<any> {
        return this.http.get(AppConfigs.API_ENDPOINT + '/mensagens/usuario/1/3');
    }
}
