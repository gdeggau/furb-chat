import { Component, OnInit } from '@angular/core';
import { CadastroService } from 'src/providers/cadastro-service';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { UtilsService } from '../commons/utils.service';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.page.html',
  styleUrls: ['./cadastro.page.scss'],
})
export class CadastroPage implements OnInit {

  private formUsuario: FormGroup;
  
  constructor(public formBuilder: FormBuilder,
              public cadastroService: CadastroService,
              public utils: UtilsService) { }

  ngOnInit() {
    this.formUsuario = this.formBuilder.group({
      'nmUsuario': new FormControl('', Validators.required),
      'nmExibicao': new FormControl('', Validators.required),
      'dtNascimento': new FormControl('', Validators.required),
      'nrTelefone': new FormControl('', Validators.required),
      'dsEmail': new FormControl('', Validators.required),
      'dsSenha': new FormControl('', Validators.required),
      'dsSenhaConf': new FormControl('', Validators.required),
      'dsFrasePerfil': new FormControl('', Validators.required)
    });
  }

  cadastrar() {
    let usuario = this.formUsuario.value;
    if (usuario.dsSenha == usuario.dsSenhaConf) {
      let md5 = require('md5');
      usuario.dsSenha = md5(usuario.dsSenha);
      usuario.dtNascimento = null;//this.utils.formatarDataServico(usuario.dtNascimento);
      this.cadastroService.postUsuario(usuario);
    } else {
      alert('As senhas devem ser iguais.');
    }
  }

}
