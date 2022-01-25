import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';

import { AboutMe } from '../models/about-me';
import { trimTrailingNulls } from '@angular/compiler/src/render3/view/util';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {
  private aboutMesUrl = '/AboutMes';

  constructor( private http: HttpClient) { }

  getAboutMes(): Observable<AboutMe[]> {
    return this.http.get<AboutMe[]>(this.aboutMesUrl)
  }

  getAboutMe(): Observable<AboutMe> {
  }

  async updateAboutMe(aboutme: AboutMe): Observable<any> {
    if (this.userServ.loggedInUser && (this.aboutMe.user = this.userServ.loggedInUser)) {
      let success = await this.userServ.updateAboutMe(this.aboutMe.id, this.userServ.loggedInUser, this.aboutMe.media, this.aboutMe.age, this.aboutMe.certs, this.aboutMe.description, this.aboutMe.experience, );
      if (success) {
      this.aboutMe.age =  this.aboutMe.age;
      this.aboutMe.certs = this.aboutMe.certs;
      this.aboutMe.description = this.aboutMe.description;
      this.aboutMe.experience = this.aboutMe.experience;
      this.aboutMe.media = this.aboutMe.media;
    } else this.message = 'Something went wrong. Please try again later.';
    } else {
      this.message = 'You have to be logged in to edit user profile!';
    }
}
searchAboutMes(term: string): Observable<AboutMe[]> {
  if (!term.trim()) {
    return of([]);
  }
  return this.http.get<AboutMe[]>('${this.aboutMeUrl}/?')
}
}
