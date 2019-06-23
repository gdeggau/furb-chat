import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Routes, RouterModule } from '@angular/router';

import { IonicModule } from '@ionic/angular';

import { GrupoPage } from './grupo.page';
import { GrupoService } from 'src/providers/grupo-service';
import { ContatosService } from 'src/providers/contatos-service';
import { UtilsService } from '../commons/utils.service';

const routes: Routes = [
  {
    path: ':id',
    component: GrupoPage
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
    GrupoService,
    ContatosService,
    UtilsService
  ],
  declarations: [GrupoPage]
})
export class GrupoPageModule {}
