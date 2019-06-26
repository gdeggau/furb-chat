import { Component } from '@angular/core';
import { ConversasService } from 'src/providers/conversas-service';
import { UtilsService } from '../commons/utils.service';
import { Router } from '@angular/router';
import { timer } from 'rxjs';

declare const require: any;

@Component({
  selector: 'app-conversas',
  templateUrl: 'conversas.page.html',
  styleUrls: ['conversas.page.scss']
})
export class ConversasPage {
  private usuario: any;
  private conversas: Array<any>;

  constructor(public conversasService: ConversasService,
              public utils: UtilsService,
              public router: Router) {
  }

  atualizarConversas() {
    timer(0, 2000).subscribe(() => {
      this.conversasService.getConversas(this.usuario).subscribe(conversas => {
        this.conversas = conversas;
      });
    });
  }

  ionViewDidEnter() {
    this.utils.verificarUsuarioLogado();
    this.usuario = this.utils.getUsuarioLogado().idUsuario;
    this.atualizarConversas();
  }

  formatarData(data: string): string {
    let moment = require('moment');
    return moment(data).format('lll');
  }

  abrirConversa(conversa: any) {
    if (conversa.flDestino == 'U') {
      this.router.navigate(['conversa/'+conversa.idDestino]);
    } else {
      this.router.navigate(['grupo/'+conversa.idDestino]);
    }
  }
}
