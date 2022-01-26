import { Component, Input, OnInit } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { AboutMe } from '../../models/about-me';
import { Person } from 'src/app/models/person';
import { UserService } from '../../services/user.service';



@Component({
  selector: 'app-profile',
  templateUrl: './profiles.component.html',
  styleUrls: ['./profiles.component.css']
})
export class ProfilesComponent implements OnInit {
  aboutMes = AboutMe[] = [];
  private aboutMesUrl = '/AboutMes'
  user:Person;

  constructor(private http: HttpClient, public userServ: UserService) { }

  ngOnInit(): void {
    this.getAboutMes();
    
    this.userServ.checkLogin().then(resp => {
      this.user=this.userServ.loggedInUser;
      console.log(this.user);
    });
  }

  getAboutMes(): Observable<AboutMe[]> {
    return this.http.get<AboutMe[]>(this.aboutMesUrl);
  }

  getAboutMe(id: number): Observable<AboutMe> {
    const url = '${this.aboutMeUrl}/${id}';
    return this.http.get<AboutMe>(url);
  }

  searchAboutMes(term: string): Observable<AboutMe[]> {
    if (!term.trim()) {
      return of([]);
    }
    return this.http.get<AboutMe[]>('${this.aboutMeUrl}/?')
  }

} 

