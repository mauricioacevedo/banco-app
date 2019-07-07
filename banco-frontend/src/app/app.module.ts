import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavComponent } from './nav/nav.component';
import { ClienteComponent } from './cliente/cliente.component';
import { TarjetaComponent } from './tarjeta/tarjeta.component';
import { ConsumoComponent } from './consumo/consumo.component';
import { AsesorComponent } from './asesor/asesor.component';
import { HomeComponent } from './home/home.component';

import {HttpClientModule} from '@angular/common/http';
import {ClienteService} from './services/cliente.service';

import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatButtonModule, MatDialogModule} from '@angular/material';
import 'hammerjs';
import { ConsumoDialogComponent } from './cliente/consumo-dialog/consumo-dialog.component';
import { AddAsesorDialogComponent } from './asesor/add-asesor-dialog/add-asesor-dialog.component';
import { ReactiveFormsModule } from '@angular/forms';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    ClienteComponent,
    TarjetaComponent,
    ConsumoComponent,
    AsesorComponent,
    HomeComponent,
    ConsumoDialogComponent,
    AddAsesorDialogComponent
  ],
  entryComponents: [ConsumoDialogComponent,AddAsesorDialogComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule, 
    MatDialogModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [ClienteService],
  bootstrap: [AppComponent]
})
export class AppModule { }
