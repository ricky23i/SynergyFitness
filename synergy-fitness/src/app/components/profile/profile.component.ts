import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { AboutMe } from 'src/app/models/about-me';
import { Person } from 'src/app/models/person';
import { UserService } from 'src/app/services/user.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-profiles',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  @Input() aboutMe?: AboutMe;
  private aboutMeUrl = '/AboutMe'
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
  
  message:string="";
  user:Person;


  constructor(
    private route: ActivatedRoute, 
    private userServ: UserService,
    private location: Location,
    private http: HttpClient
  ) { }

  ngOnInit(): void {
    this.userServ.checkLogin().then(resp => {
      this.user=this.userServ.loggedInUser;
      console.log(this.user);
    });
  }

  goBack(): void {
    this.location.back();
  }
  // async updateAboutMe(aboutme: AboutMe){
  //   if (this.userServ.loggedInUser && (this.aboutMe.user = this.userServ.loggedInUser)) {
  //     let success = await this.updateAboutMe(this.aboutMe);
  //     if (success) {
  //     this.aboutMe.age =  this.aboutMe.age;
  //     this.aboutMe.certs = this.aboutMe.certs;
  //     this.aboutMe.description = this.aboutMe.description;
  //     this.aboutMe.experience = this.aboutMe.experience;
  //     this.aboutMe.media = this.aboutMe.media;
  //     this.message = "AboutMe Updated";
  //   } else this.message = 'Something went wrong. Please try again later.';
  //   } else {
  //     this.message = 'You have to be logged in to edit user profile!';
  //   }
  // }

  updateAboutMe(aboutMe: AboutMe): Observable<any> {
    return this.http.put(this.aboutMeUrl, aboutMe, this.httpOptions);
  }
  // async updateAboutMe(aboutme: AboutMe): Promsie<boolean> {
  //   this.authHeaders.Token 
  //   let resp = await fetch(this.url.url + 'AboutMes/' + this.aboutMe.id), {method:'PUT', body:JSON.stringify(aboutme)}
  //   if (resp.status===200) return true;
  //   else return false;
}

