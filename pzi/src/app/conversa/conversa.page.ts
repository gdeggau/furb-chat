import { Component } from '@angular/core';
import { ConversaService } from 'src/providers/conversa-service';
import { FormBuilder, FormControl, Validators, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-conversa',
  templateUrl: './conversa.page.html',
  styleUrls: ['./conversa.page.scss'],
})
export class ConversaPage {
  private mensagens: Array<any>;
  private formMensagem: FormGroup;

  constructor(public formBuilder: FormBuilder,
              public conversaService: ConversaService) {
  }

  ionViewDidEnter() {
    this.conversaService.getConversa().subscribe(mensagens => {
      this.mensagens = mensagens;
    })
  }

  ngOnInit() {
    this.formMensagem = this.formBuilder.group({
      'dsMensagem': new FormControl('', Validators.required)
    });
  }

  enviarMensagemTexto() {
    let mensagem = this.formMensagem.value;
    mensagem.idUsuarioEnvio = {
      idUsuario: 1
    };
    this.conversaService.postMensagemTexto(mensagem);
  }

}
