import { Component } from '@angular/core';
import { ConversaService } from 'src/providers/conversa-service';
import { FormBuilder, FormControl, Validators, FormGroup } from '@angular/forms';
import { UtilsService } from '../commons/utils.service';
import { utils } from 'protractor';

@Component({
  selector: 'app-conversa',
  templateUrl: './conversa.page.html',
  styleUrls: ['./conversa.page.scss'],
})
export class ConversaPage {
  private usuario: any;
  private mensagens: Array<any>;
  private formMensagem: FormGroup;

  constructor(public formBuilder: FormBuilder,
              public conversaService: ConversaService,
              public utils: UtilsService) {
  }

  ionViewDidEnter() {
    this.conversaService.getUsuarioConversa(3).subscribe(usuario => {
      this.usuario = usuario;
    });
    this.conversaService.getConversa(3).subscribe(mensagens => {
      this.mensagens = mensagens;
    });
  }

  ngOnInit() {
    this.formMensagem = this.formBuilder.group({
      'dsMensagem': new FormControl('', Validators.required)
    });
  }

  enviarMensagemTexto() {
    let mensagem = this.formMensagem.value;
    mensagem.idUsuarioEnvio = {
      idUsuario: this.utils.getIdUsuarioLogado()
    };
    this.conversaService.postMensagemTexto(mensagem, 3);
  }

}
