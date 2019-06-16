import { Component } from '@angular/core';
import { ContatosService } from 'src/providers/contatos-service';
import { UtilsService } from '../commons/utils.service';

@Component({
  selector: 'app-contatos',
  templateUrl: 'contatos.page.html',
  styleUrls: ['contatos.page.scss']
})
export class ContatosPage {
  private contatos: Array<any>;

  constructor(public contatosService: ContatosService,
              public utils: UtilsService) {
  }

  ionViewDidEnter() {
    this.utils.verificarUsuarioLogado();
    this.contatosService.getContatos().subscribe(contatos => {
      this.contatos = contatos;
    })
  }
}
