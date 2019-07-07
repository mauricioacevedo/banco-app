import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import {MatDialogRef} from "@angular/material";
import { AsesorService } from 'src/app/services/asesor.service';
import {Asesor} from '../asesor';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-add-asesor-dialog',
  templateUrl: './add-asesor-dialog.component.html',
  styleUrls: ['./add-asesor-dialog.component.scss']
})
export class AddAsesorDialogComponent implements OnInit {

  asesor: Asesor;

  form = new FormGroup({
    nombre: new FormControl(''),
    especialidad: new FormControl('')
  });

  constructor(private dialogRef: MatDialogRef<AddAsesorDialogComponent>,
    private datos: AsesorService,private route: ActivatedRoute, private router: Router) { 
      this.asesor = new Asesor();
    }

  ngOnInit() {
  }

  submit() {
    //call service...
    this.dialogRef.close();
    this.datos.save(this.asesor).subscribe(result => {
      //console.log(result);
      this.gotoAsesores()
    });
  }

  gotoAsesores(){
    this.router.navigate(['/']);
  }
}
