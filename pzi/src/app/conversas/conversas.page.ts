import { Component } from '@angular/core';
import { ConversasService } from 'src/providers/conversas-service';
import { UtilsService } from '../commons/utils.service';
import { Router } from '@angular/router';

declare const require: any;

@Component({
  selector: 'app-conversas',
  templateUrl: 'conversas.page.html',
  styleUrls: ['conversas.page.scss']
})
export class ConversasPage {
  private conversas: Array<any>;

  constructor(public conversasService: ConversasService,
              public utils: UtilsService,
              public router: Router) {
  }

  ionViewDidEnter() {
    this.utils.verificarUsuarioLogado();
    this.conversasService.getConversas(this.utils.getUsuarioLogado().idUsuario).subscribe(conversas => {
      this.conversas = conversas;
      console.log(conversas)
    });
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
