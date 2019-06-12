import { Component } from '@angular/core';
import { ConversaService } from 'src/providers/conversa-service';

@Component({
  selector: 'app-conversa',
  templateUrl: './conversa.page.html',
  styleUrls: ['./conversa.page.scss'],
})
export class ConversaPage {
  private mensagens: Array<any>;

  constructor(public conversaService: ConversaService) {
  }

  ionViewDidEnter() {
    this.conversaService.getConversa().subscribe(mensagens => {
      this.mensagens = mensagens;
    })
  }

}
