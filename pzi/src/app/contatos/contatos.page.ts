import { Component } from '@angular/core';
import { ContatosService } from 'src/providers/contatos-service';
import { UtilsService } from '../commons/utils.service';
import { Router } from '@angular/router';
import { AlertController } from '@ionic/angular';
import { timer } from 'rxjs';

@Component({
  selector: 'app-contatos',
  templateUrl: 'contatos.page.html',
  styleUrls: ['contatos.page.scss']
})
export class ContatosPage {
  private usuario: any;
  private contatos: Array<any>;

  constructor(public contatosService: ContatosService,
              public utils: UtilsService,
              public router: Router,
              public alert: AlertController) {
  }

  atualizarListaContatos() {
    timer(0, 2000).subscribe(() => {
      this.contatosService.getContatos(this.usuario).subscribe(contatos => {
        this.contatos = contatos;
      });
    });
  }

  ionViewDidEnter() {
    this.utils.verificarUsuarioLogado();
    this.usuario = this.utils.getUsuarioLogado().idUsuario;
    this.atualizarListaContatos();
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

  async criarGrupo() {
    const alertPrompt = await this.alert.create({
      header: 'Novo grupo',
      inputs: [
        {
          placeholder: 'Nome do grupo'
        }
      ],
      buttons: [
        {
          text: 'Cancelar'
        },
        {
          text: 'Criar grupo',
          handler: data => {
            let nome = data[0];
            if (nome) {
              this.contatosService.postGrupo(nome, this.utils.getUsuarioLogado());
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
