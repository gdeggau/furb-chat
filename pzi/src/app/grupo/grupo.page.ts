import { Component, OnInit } from '@angular/core';
import { GrupoService } from 'src/providers/grupo-service';
import { AlertController } from '@ionic/angular';
import { ContatosService } from 'src/providers/contatos-service';
import { UtilsService } from '../commons/utils.service';
import { ActivatedRoute } from '@angular/router';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-grupo',
  templateUrl: './grupo.page.html',
  styleUrls: ['../conversa/conversa.page.scss'],
})
export class GrupoPage implements OnInit {
  private formMensagem: FormGroup;

  private id = this.activatedRoute.snapshot.params['id'];

  constructor(public grupoService: GrupoService,
              public contatosService: ContatosService,
              public alert: AlertController,
              public utils: UtilsService,
              public activatedRoute: ActivatedRoute,
              public formGroup: FormBuilder) { }

  iniciarForm() {
    this.formMensagem = this.formGroup.group({
      'dsMensagem': new FormControl('', Validators.required)
    });
  }

  ngOnInit() {
    this.iniciarForm();
    this.utils.verificarUsuarioLogado();
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

  async adicionarContatoGrupo() {
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
