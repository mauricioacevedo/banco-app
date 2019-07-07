import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Cliente} from '../cliente/cliente.interface';


@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  api_url: string = 'http://localhost:8080/';
  constructor(private http: HttpClient) { }

  getClientes(): Observable<Cliente[]> {
    console.log('Loading clientes..');
    return this.http.get<Cliente[]>(`${this.api_url}/clientes`);
  }
}
