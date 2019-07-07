import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from  './home/home.component';
import {ClienteComponent} from './cliente/cliente.component';
import {ConsumoComponent} from './consumo/consumo.component';
import {AsesorComponent} from './asesor/asesor.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'clientes', component: ClienteComponent},
  {path: 'consumos', component: ConsumoComponent},
  {path: 'asesores', component: AsesorComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
