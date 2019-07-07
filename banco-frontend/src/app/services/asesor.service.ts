import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Asesor} from '../asesor/asesor';

@Injectable({
  providedIn: 'root'
})
export class AsesorService {

  api_url: string = 'http://localhost:8080/';
  constructor(private http: HttpClient) { }

  getAsesores(): Observable<Asesor[]> {
    console.log('Loading asesores..');
    return this.http.get<Asesor[]>(`${this.api_url}/asesores`);
  }

  save(asesor: Asesor){
    return this.http.post<Asesor>(`${this.api_url}/asesores`,asesor);
  }
}
