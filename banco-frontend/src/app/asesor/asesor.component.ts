import { Component, OnInit } from '@angular/core';
import {AsesorService} from '../services/asesor.service';
import {Asesor} from '../cliente/asesor.interface';
import {MatDialog, MatDialogConfig} from "@angular/material";
import { AddAsesorDialogComponent } from './add-asesor-dialog/add-asesor-dialog.component';

@Component({
  selector: 'app-asesor',
  templateUrl: './asesor.component.html',
  styleUrls: ['./asesor.component.scss']
})
export class AsesorComponent implements OnInit {

  asesores: Asesor[];
  constructor(private data: AsesorService, private dialog: MatDialog) { }

  ngOnInit() {
    this.getAsesores();

  }

  getAsesores(){
    return this.data.getAsesores()
    .subscribe(
      (datos: Asesor[]) => {
        this.asesores = datos;
        
      }
    );
  }

  add(){
    const dialogConfig = new MatDialogConfig();

        dialogConfig.disableClose = true;
        dialogConfig.autoFocus = true;
        dialogConfig.width = "60%";

        this.dialog.open(AddAsesorDialogComponent, dialogConfig);
  }
}


