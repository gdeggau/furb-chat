import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { AppConfigs } from 'src/app/commons/app-configs';

@Injectable()
export class ContatosService {
    constructor(public http : HttpClient) {
    }

    getContatos(): Observable<any> {
        return this.http.get(AppConfigs.API_ENDPOINT + '/usuarios');
    }
}
