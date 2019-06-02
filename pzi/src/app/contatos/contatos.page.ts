import { Component } from '@angular/core';
import { NavController, NavParams } from '@ionic/angular';
import { ContatosService } from 'src/providers/contatos-service';

@Component({
  selector: 'app-contatos',
  templateUrl: 'contatos.page.html',
  styleUrls: ['contatos.page.scss']
})
export class ContatosPage {
  private contatos: Array<any>;

  constructor(/*public navCtrl: NavController, public navParams: NavParams,
              */public contatosService: ContatosService) {
  }

  ionViewDidEnter() {
    this.contatosService.getContatos().subscribe(contatos => {
      this.contatos = contatos;
    })
  }
}
