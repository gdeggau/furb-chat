import { Component } from '@angular/core';
import { ContatosService } from 'src/providers/contatos-service';
import { UtilsService } from '../commons/utils.service';
import { Router } from '@angular/router';
import { AlertController } from '@ionic/angular';

@Component({
  selector: 'app-contatos',
  templateUrl: 'contatos.page.html',
  styleUrls: ['contatos.page.scss']
})
export class ContatosPage {
  private contatos: Array<any>;

  constructor(public contatosService: ContatosService,
              public utils: UtilsService,
              public router: Router,
              public alert: AlertController) {
  }

  ionViewDidEnter() {
    this.utils.verificarUsuarioLogado();
    this.contatosService.getContatos(this.utils.getUsuarioLogado().idUsuario).subscribe(contatos => {
      this.contatos = contatos;
    });
  }

  async adicionarContato() {
    const alertPrompt = await this.alert.create({
      header: 'Telefone',
      inputs: [
        {
          placeholder: 'Telefone'
        }
      ],
      buttons: [
        {
          text: 'Cancelar'
        },
        {
          text: 'Confirmar',
          handler: data => {
            let telefone = data[0];
            if (telefone) {
              this.contatosService.postContato(telefone, this.utils.getUsuarioLogado());
            }
          }
        }
      ]
    });
    await alertPrompt.present();
  }

  iniciarConversa(contato: any) {
    this.router.navigate(['conversa/'+contato.idUsuario]);
  }
}
