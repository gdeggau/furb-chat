import { IonicModule } from '@ionic/angular';
import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ConversasPage } from './conversas.page';
import { ConversasService } from 'src/providers/conversas-service';
import { UtilsService } from '../commons/utils.service';

@NgModule({
  imports: [
    IonicModule,
    CommonModule,
    FormsModule,
    RouterModule.forChild([{ path: '', component: ConversasPage }])
  ],
  providers: [
    ConversasService,
    UtilsService
  ],
  declarations: [ConversasPage]
})
export class ConversasPageModule {}
