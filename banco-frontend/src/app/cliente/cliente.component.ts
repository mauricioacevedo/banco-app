import { Component, OnInit } from '@angular/core';

import {ClienteService} from '../services/cliente.service';
import {Cliente} from './cliente.interface';
import {MatDialog, MatDialogConfig} from "@angular/material";
import { ConsumoDialogComponent } from './consumo-dialog/consumo-dialog.component';
import { Tarjeta } from './tarjeta.interface';

@Component({
  selector: 'app-cliente',
  templateUrl: './cliente.component.html',
  styleUrls: ['./cliente.component.scss']
})
export class ClienteComponent implements OnInit {

  clientes: Cliente[];
  constructor(private data: ClienteService, private dialog: MatDialog) { }

  ngOnInit() {
    this.getClientes();
  }

  getClientes(){
    return this.data.getClientes()
    .subscribe(
      (datos: Cliente[]) => {
        this.clientes = datos;
        
      }
    );
  }

  getConsumos(tarjetaId:number){

  }

  show(c:Cliente, tarj: Tarjeta){
    
    const dialogConfig = new MatDialogConfig();

        dialogConfig.disableClose = true;
        dialogConfig.autoFocus = true;
        dialogConfig.width = "60%";
        dialogConfig.data = {
          cliente: c,
          tarjeta: tarj
        }

        this.dialog.open(ConsumoDialogComponent, dialogConfig);
  }

}
