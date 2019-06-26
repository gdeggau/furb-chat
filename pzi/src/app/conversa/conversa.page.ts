import { Component } from '@angular/core';
import { ConversaService } from 'src/providers/conversa-service';
import { FormBuilder, FormControl, Validators, FormGroup } from '@angular/forms';
import { UtilsService } from '../commons/utils.service';
import { Router, ActivatedRoute } from '@angular/router';
import { timer } from 'rxjs';

@Component({
  selector: 'app-conversa',
  templateUrl: './conversa.page.html',
  styleUrls: ['./conversa.page.scss'],
})
export class ConversaPage {
  private usuario: any;
  private mensagens: Array<any>;
  private formMensagem: FormGroup;

  private id = this.activatedRoute.snapshot.params['id'];

  constructor(public formBuilder: FormBuilder,
              public conversaService: ConversaService,
              public utils: UtilsService,
              public router: Router,
              public activatedRoute: ActivatedRoute) {
  }

  async atualizarConversa() {
    timer(0, 2000).subscribe(() => {
      this.conversaService.getConversa(this.id).subscribe(mensagens => {
        this.mensagens = mensagens;
      });
    });
  }

  ionViewDidEnter() {
    this.conversaService.getUsuarioConversa(this.id).subscribe(usuario => {
      this.usuario = usuario;
    });
    this.atualizarConversa();
  }

  iniciarForm() {
    this.formMensagem = this.formBuilder.group({
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
    this.conversaService.postMensagemTexto(mensagem, this.id);
    this.iniciarForm();
  }

}
