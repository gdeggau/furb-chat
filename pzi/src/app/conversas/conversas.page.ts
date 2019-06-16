import { Component } from '@angular/core';
import { ConversasService } from 'src/providers/conversas-service';
import { UtilsService } from '../commons/utils.service';
import { Router } from '@angular/router';

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
    });
  }

  abrirConversa(conversa: any) {
    this.router.navigate(['conversa/'+conversa.idUsuarioEnvio.idUsuario]);
  }
}
