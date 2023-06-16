import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DocumentosService {

  private API_SERVER = "http://localhost:8080/documento/";

  constructor(
    private httpClient: HttpClient
  ) { }


  public getAllPaises(): Observable<any>{
    return this.httpClient.get(this.API_SERVER);
  }

}
