import { Component, OnInit } from '@angular/core';
import { GrupoService } from 'src/providers/grupo-service';
import { AlertController } from '@ionic/angular';
import { ContatosService } from 'src/providers/contatos-service';
import { UtilsService } from '../commons/utils.service';
import { ActivatedRoute } from '@angular/router';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { timer } from 'rxjs';

@Component({
  selector: 'app-grupo',
  templateUrl: './grupo.page.html',
  styleUrls: ['../conversa/conversa.page.scss'],
})
export class GrupoPage implements OnInit {
  private grupo: any;
  private mensagens: Array<any>;
  private formMensagem: FormGroup;

  private id = this.activatedRoute.snapshot.params['id'];

  constructor(public grupoService: GrupoService,
              public contatosService: ContatosService,
              public alert: AlertController,
              public utils: UtilsService,
              public activatedRoute: ActivatedRoute,
              public formGroup: FormBuilder) { }

  async atualizarConversa() {
    timer(0, 2000).subscribe(() => {
      this.grupoService.getConversaGrupo(this.id).subscribe(mensagens => {
        this.mensagens = mensagens;
      });
    });
  }

  ionViewDidEnter() {
    this.grupoService.getGrupo(this.id).subscribe(grupo => {
      this.grupo = grupo;
    });
    this.atualizarConversa();
  }

  iniciarForm() {
    this.formMensagem = this.formGroup.group({
      'dsMensagem': new FormControl('', Validators.required)
    });
  }

  ngOnInit() {
    this.iniciarForm();
    this.utils.verificarUsuarioLogado();
  }

  isAdm() {
    if (this.grupo) {
      return this.utils.getUsuarioLogado().idUsuario == this.grupo.idUsuarioCadastro.idUsuario;
    }
    return false;
  }

  obterTipoRemetente(msg: any): number {
    if (msg.idUsuarioEnvio.idUsuario == 0) {
      return 0;
    } else if (msg.idUsuarioEnvio.idUsuario == this.utils.getUsuarioLogado().idUsuario) {
      return 1;
    } else {
      return 2;
    }
  }

  enviarMensagemTexto() {
    let mensagem = this.formMensagem.value;
    mensagem.idUsuarioEnvio = this.utils.getUsuarioLogado();
    this.grupoService.postMensagemTexto(mensagem, this.id);
    this.iniciarForm();
  }

  obterContatosAsCheckbox() {
    let lista = [];
    this.contatosService.getContatos(this.utils.getUsuarioLogado().idUsuario).subscribe(contatos => {
    //this.contatosService.getContatosForaDoGrupo(this.utils.getUsuarioLogado().idUsuario, this.grupo.idGrupo).subscribe(contatos => {
      contatos.forEach(contato => {
        lista.push({
          type: 'checkbox',
          label: contato.nmExibicao,
          value: contato.idUsuario
        });
      });
    });
    return lista;
  }

  async adicionarContatosGrupo() {
    const alertCheckbox = await this.alert.create({
      header: 'Selecione os contatos:',
      inputs: this.obterContatosAsCheckbox(),
      buttons: [
        {
          text: 'Cancelar'
        },
        {
          text: 'Adicionar ao grupo',
          handler: data => {
            this.grupoService.postContatosGrupo(this.id, data);
          }
        }
      ]
    });
    await alertCheckbox.present();
  }

}
