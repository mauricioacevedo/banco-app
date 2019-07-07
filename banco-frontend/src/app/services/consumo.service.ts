import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Consumo} from '../cliente/consumo.interface';

@Injectable({
  providedIn: 'root'
})
export class ConsumoService {

  api_url: string = 'http://localhost:8080/';
  constructor(private http: HttpClient) { }

  getConsumos(tarjetaId: Int16Array){
    console.log('Cheching consumos..');
    return this.http.get<Consumo[]>(`${this.api_url}/consumos/detalles/${tarjetaId}`);
  }
}
