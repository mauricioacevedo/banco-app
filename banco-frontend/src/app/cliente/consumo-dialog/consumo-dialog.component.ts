import { Component, OnInit, Inject } from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material";
import { FormGroup, FormBuilder } from '@angular/forms';
import { Consumo } from '../consumo.interface';
import { Cliente } from '../cliente.interface';
import { Tarjeta } from '../tarjeta.interface';
import { ConsumoService } from 'src/app/services/consumo.service';

@Component({
  selector: 'consumo-dialog',
  templateUrl: './consumo-dialog.component.html',
  styleUrls: ['./consumo-dialog.component.scss']
})
export class ConsumoDialogComponent implements OnInit {

  form: FormGroup;
  consumos: Consumo[];
  cliente: Cliente;
  tarjeta: Tarjeta;

  constructor(
    private dialogRef: MatDialogRef<ConsumoDialogComponent>,
    @Inject(MAT_DIALOG_DATA) data, private datos: ConsumoService) { 
      this.cliente = data.cliente;
      this.tarjeta = data.tarjeta;

    }

  ngOnInit() {
    this.getConsumos(this.tarjeta.id);
  }

  getConsumos(tarjetaId:Int16Array){
    return this.datos.getConsumos(tarjetaId)
    .subscribe(
      (consums: Consumo[]) => {
        this.consumos = consums;
      }
    );
  }

  save() {
    this.dialogRef.close(this.form.value);
  }

  close() {
    this.dialogRef.close();
  }

}
