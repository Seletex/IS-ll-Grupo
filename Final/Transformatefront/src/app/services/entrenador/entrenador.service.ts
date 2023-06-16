import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class EntrenadorService {
  saveEntrenador: any;
  deleteEntrenador(id: any) {
    throw new Error('Method not implemented.');
  }
  private API_SERVER = "http://localhost:8080/entrenador/";

  constructor(private httpClient: HttpClient) { }



  public getAllPersonas(): Observable<any>{
    return this.httpClient.get(this.API_SERVER);
  }

  public savePersona (persona:any): Observable<any>{
    return this.httpClient.post(this.API_SERVER,persona);
  }

  public deletePersona(id):Observable<any>{
    return this.httpClient.delete(this.API_SERVER + "delete/"+id);
  }

}
