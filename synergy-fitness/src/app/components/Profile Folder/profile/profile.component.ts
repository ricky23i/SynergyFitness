import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

import { AboutMe } from 'src/app/models/about-me';
import { Person } from 'src/app/models/person';
import { UserService } from 'src/app/services/user.service';
import { AboutMeService } from 'src/app/services/about-me.service';

@Component({
  selector: 'app-profiles',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  @Input() aboutMe: AboutMe;
  message:string="";
  user:Person;


  constructor(
    private route: ActivatedRoute, 
    private userServ: UserService,
    private aboutMeServ: AboutMeService,
    private location: Location,
  ) { }

  ngOnInit(): void {
    this.getAboutMe();

    this.userServ.checkLogin().then(resp => {
      this.user=this.userServ.loggedInUser;
      console.log(this.user);
    });
  }

  // getAboutMe(): void {
  //   const id = Number(this.route.snapshot.paramMap.get('id'));
  //   this.aboutMeServ.getAboutMe(id)
  //     .subscribe(aboutMe => this.aboutMe = aboutMe);
  // }
  async getAboutMe() { 
    if (this.aboutMe.id) {
      let aboutMe = await this.aboutMeServ.getAboutMe(this.aboutMe.id);
      if (aboutMe) this.aboutMe = aboutMe;

    }
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

  // save(): void {
  //   if (this.aboutMe) {
  //     this.aboutMeServ.updateAboutMe(this.aboutMe)
  //     .subscribe(() => this.goBack)
  //   }
  // }

  // async save(){
  //   if (this.userServ.loggedInUser){
  //     let success = await this.aboutMeServ.updateAboutMe(this.aboutMe);
  //   }
  // }
  // async updateAboutMe(aboutme: AboutMe): Promsie<boolean> {
  //   this.authHeaders.Token 
  //   let resp = await fetch(this.url.url + 'AboutMes/' + this.aboutMe.id), {method:'PUT', body:JSON.stringify(aboutme)}
  //   if (resp.status===200) return true;
  //   else return false;
}

