import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class GimnasioServise {

  private API_SERVER = "http://localhost:8080/gimnasio/";

  constructor(
    private httpClient: HttpClient
  ) { }


  public getAllPaises(): Observable<any>{
    return this.httpClient.get(this.API_SERVER);
  }

}
