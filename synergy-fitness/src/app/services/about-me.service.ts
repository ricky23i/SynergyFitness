import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders, JsonpClientBackend } from '@angular/common/http';

import { AboutMe } from '../models/about-me';
import { Person } from '../models/person';
import { UrlService } from './url.service';

@Injectable({
  providedIn: 'root'
})
export class AboutMeService {
  loggedInUser:Person;

  // private aboutMeUrl = '/AboutMe';
  private aboutMeUrl: string;
  private aboutMesUrl: string;
  private updateAboutMeUrl: string;
  private searchAboutMeUrl: string;

  authHeaders = {'Content-type':'application/json','Token':''};
  regHeaders = {'Content-type':'application/json'};

  constructor(private http: HttpClient, private urlService:UrlService) { 
    this.aboutMesUrl = urlService.url + 'AboutMe';
    this.aboutMeUrl = urlService.url + 'AboutMe/';
    this.updateAboutMeUrl = urlService.url + 'AboutMe/';
    this.searchAboutMeUrl = urlService.url + 'AboutMe/?name';
  }

  // getAboutMes(): Observable<AboutMe[]> {
  //   return this.http.get<AboutMe[]>(this.aboutMeUrl)
  // }
  async getAboutMes(): Promise<AboutMe[]> {
    let response = await fetch(this.aboutMesUrl);

    if (response.status===200 || response.status===201) {
      return await response.json();
    } else return null;
  }

  // getAboutMe(id: number): Observable<AboutMe> {
  //   const url = `${this.aboutMeUrl}/${id}`;
  //   return this.http.get<AboutMe>(url);
  // }
  async getAboutMe(id: number): Promise<AboutMe> {
    let response = await fetch(this.aboutMeUrl + id);
    if (response.status===200) {
      return await response.json();
    } else return null;
  }

  // updateAboutMe(aboutMe: AboutMe): Observable<any> {
  // return this.http.put(this.aboutMeUrl, aboutMe, this.httpOptions)
  // }
  async updateAboutMe(aboutMe: AboutMe): Promise<Boolean> {
    let response = await fetch(this.updateAboutMeUrl + aboutMe.aboutMeId, {
      method: 'POST',
      body: JSON.stringify(aboutMe),
      headers: this.regHeaders
    });
      if (response.status===201) return true;
      else return false;
  }

  searchAboutMe(term: string): Observable<AboutMe[]> {
    if (!term.trim()) {
      return of([]);
    }
    return this.http.get<AboutMe[]>('${this.aboutMeurl}/?name=${term}');
  }
}
