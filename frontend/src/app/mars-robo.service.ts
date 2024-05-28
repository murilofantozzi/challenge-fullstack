import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MarsRoboService {
  private apiUrl = 'http://localhost:8080/rest/mars';

  constructor(private http: HttpClient) { }

  sendCommands(commands: string): Observable<string> {
    return this.http.post(this.apiUrl + '/' + commands, {}, { responseType: 'text' });
  }
}
