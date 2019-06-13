import { IonicModule } from '@ionic/angular';
import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ConversasPage } from './conversas.page';
import { ConversasService } from 'src/providers/conversas-service';

@NgModule({
  imports: [
    IonicModule,
    CommonModule,
    FormsModule,
    RouterModule.forChild([{ path: '', component: ConversasPage }])
  ],
  providers: [
    ConversasService
  ],
  declarations: [ConversasPage]
})
export class ConversasPageModule {}
