import { Component } from '@angular/core';
import { ConversasService } from 'src/providers/conversas-service';

@Component({
  selector: 'app-conversas',
  templateUrl: 'conversas.page.html',
  styleUrls: ['conversas.page.scss']
})
export class ConversasPage {
  private conversas: Array<any>;

  constructor(public conversasService: ConversasService){

  }

  ionViewDidEnter() {
    this.conversasService.getConversas().subscribe(conversas => {
      this.conversas = conversas;
    })
  }
}
