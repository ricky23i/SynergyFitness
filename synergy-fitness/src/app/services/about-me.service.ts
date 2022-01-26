import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { AboutMe } from '../models/about-me';
import { Person } from '../models/person';

@Injectable({
  providedIn: 'root'
})
export class AboutMeService {

  private aboutMeUrl = '/AboutMe';
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor( private http: HttpClient) { }

  getAboutMes(): Observable<AboutMe[]> {
    return this.http.get<AboutMe[]>(this.aboutMeUrl);
  }

  getAboutMe(id: number): Observable<AboutMe> {
    const url = `${this.aboutMeUrl}/${id}`;
    return this.http.get<AboutMe>(url);
  }

  updateAboutMe(aboutMe: AboutMe): Observable<any> {
  return this.http.put(this.aboutMeUrl, aboutMe, this.httpOptions)
  }
  searchAboutMe(term: string): Observable<AboutMe[]> {
    if (!term.trim()) {
      return of([]);
    }
    return this.http.get<AboutMe[]>('${this.aboutMeurl}/?name=${term}');
  }
}
