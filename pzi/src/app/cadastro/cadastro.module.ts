import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, FormBuilder, ReactiveFormsModule } from '@angular/forms';
import { Routes, RouterModule } from '@angular/router';

import { IonicModule } from '@ionic/angular';

import { CadastroPage } from './cadastro.page';
import { CadastroService } from 'src/providers/cadastro-service';
import { UtilsService } from '../commons/utils.service';

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
    RouterModule.forChild(routes),
    ReactiveFormsModule
  ],
  providers: [
    CadastroService,
    FormBuilder,
    UtilsService
  ],
  declarations: [CadastroPage]
})
export class CadastroPageModule {}
