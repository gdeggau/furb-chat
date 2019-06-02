import { IonicModule } from '@ionic/angular';
import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ContatosPage } from './contatos.page';
import { ContatosService } from 'src/providers/contatos-service';

@NgModule({
  imports: [
    IonicModule,
    CommonModule,
    FormsModule,
    RouterModule.forChild([{ path: '', component: ContatosPage }])
  ],
  providers: [
    ContatosService
  ],
  declarations: [ContatosPage]
})
export class ContatosPageModule {}
