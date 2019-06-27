import { Component } from '@angular/core';
import { UtilsService } from '../commons/utils.service';

@Component({
  selector: 'app-perfil',
  templateUrl: 'perfil.page.html',
  styleUrls: ['perfil.page.scss']
})
export class PerfilPage {

  constructor(public utils: UtilsService) {
  }

  sair() {
    this.utils.logoff();
  }

}
