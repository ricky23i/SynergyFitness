import { Component, Input, OnInit } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { AboutMe } from '../../models/about-me';
import { UserService } from '../../services/user.service';


@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  aboutMes = AboutMe[] = [];
  private aboutMesUrl = '/AboutMes'

  constructor(private http: HttpClient, public userServ: UserService) { }

  ngOnInit(): void {
    this.getAboutMes();
  }

  getAboutMes(): Observable<AboutMe[]> {
    return this.http.get<AboutMe[]>(this.aboutMesUrl)
  }

  getAboutMe(): Observable<AboutMe> {
  }

  searchAboutMes(term: string): Observable<AboutMe[]> {
    if (!term.trim()) {
      return of([]);
    }
    return this.http.get<AboutMe[]>('${this.aboutMeUrl}/?')
  }

} 

