import { Component } from '@angular/core';
import { ContatosService } from 'src/providers/contatos-service';
import { UtilsService } from '../commons/utils.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-contatos',
  templateUrl: 'contatos.page.html',
  styleUrls: ['contatos.page.scss']
})
export class ContatosPage {
  private contatos: Array<any>;

  constructor(public contatosService: ContatosService,
              public utils: UtilsService,
              public router: Router) {
  }

  ionViewDidEnter() {
    this.utils.verificarUsuarioLogado();
    this.contatosService.getContatos(this.utils.getUsuarioLogado().idUsuario).subscribe(contatos => {
      this.contatos = contatos;
    });
  }

  adicionarContato() {
    let telefone = prompt('Telefone:');
    if (telefone) {
      this.contatosService.postContato(telefone, this.utils.getUsuarioLogado());
    }
  }

  iniciarConversa(contato: any) {
    this.router.navigate(['conversa/'+contato.idUsuario]);
  }
}
