import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Routes, RouterModule } from '@angular/router';

import { IonicModule } from '@ionic/angular';

import { CadastroPage } from './cadastro.page';
import { CadastroService } from 'src/providers/cadastro-service';

const routes: Routes = [
  {
    path: '',
    component: CadastroPage
  }
];

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    RouterModule.forChild(routes)
  ],
  providers: [
    CadastroService
  ],
  declarations: [CadastroPage]
})
export class CadastroPageModule {}
