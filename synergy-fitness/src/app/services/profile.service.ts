import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';

import { AboutMe } from '../models/about-me';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {
  private aboutMesUrl = '/AboutMes';

  constructor( private http: HttpClient) { }

  getAboutMes(): Observable<AboutMe[]> {
    return this.http.get<AboutMe[]>(this.aboutMesUrl)
  }
}

