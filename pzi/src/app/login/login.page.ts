import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { LoginService } from 'src/providers/login-service';
import { UtilsService } from '../commons/utils.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.page.html',
  styleUrls: ['./login.page.scss'],
})
export class LoginPage implements OnInit {

  private formLogin: FormGroup;
  
  constructor(public formBuilder: FormBuilder,
              public loginService: LoginService,
              public utils: UtilsService,
              public router: Router) { }

  iniciarForm(nrTelefone: string) {
    this.formLogin = this.formBuilder.group({
      'nrTelefone': new FormControl(nrTelefone, Validators.required),
      'dsSenha': new FormControl('', Validators.required)
    });
  }

  ngOnInit() {
    this.iniciarForm('');
  }

  logar() {
    let usuario = this.formLogin.value;
    let md5 = require('md5');
    usuario.dsSenha = md5(usuario.dsSenha);
    this.loginService.getUsuarioLogin(usuario).subscribe(usu => {
      this.utils.setUsuarioLogado(usu);
      this.router.navigate(['/tabs/conversas']);
    }, error => {
      this.iniciarForm(usuario.nrTelefone);
      alert('Telefone e/ou senha incorreta');
    });
  }

}
