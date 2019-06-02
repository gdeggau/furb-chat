import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';

@Injectable()
export class ContatosService {
    public API = 'http://localhost:8080';
    public PZI_API = this.API + '/pzi';

    constructor(public http : HttpClient) {
    }

    getContatos(): Observable<any> {
        return this.http.get(this.PZI_API + '/usuarios');
    }
}
