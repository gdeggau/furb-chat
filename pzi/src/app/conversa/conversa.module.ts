import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Routes, RouterModule } from '@angular/router';

import { IonicModule } from '@ionic/angular';

import { ConversaPage } from './conversa.page';
import { ConversaService } from 'src/providers/conversa-service';

const routes: Routes = [
  {
    path: '',
    component: ConversaPage
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
    ConversaService
  ],
  declarations: [ConversaPage]
})
export class ConversaPageModule {}
