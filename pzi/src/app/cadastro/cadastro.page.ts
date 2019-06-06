import { Component, OnInit } from '@angular/core';
import { CadastroService } from 'src/providers/cadastro-service';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.page.html',
  styleUrls: ['./cadastro.page.scss'],
})
export class CadastroPage implements OnInit {

  constructor(public cadastroService : CadastroService) { }

  ngOnInit() {
  }

}
