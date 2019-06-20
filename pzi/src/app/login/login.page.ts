import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { LoginService } from 'src/providers/login-service';
import { UtilsService } from '../commons/utils.service';
import { Router } from '@angular/router';
import { AlertController } from '@ionic/angular';

declare const require: any;

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
              public router: Router,
              public alert: AlertController) { }

  iniciarForm(nrTelefone: string) {
    this.formLogin = this.formBuilder.group({
      'nrTelefone': new FormControl(nrTelefone, Validators.required),
      'dsSenha': new FormControl('', Validators.required)
    });
  }

  ngOnInit() {
    this.iniciarForm('');
  }

  async presentAlert() {
    const alert = await this.alert.create({
      message: 'Telefone e/ou senha incorreta',
      buttons: ['OK']
    });
    await alert.present();
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
      this.presentAlert();
    });
  }

}
