import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

import { AboutMe } from 'src/app/models/about-me';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-profiles',
  templateUrl: './profiles.component.html',
  styleUrls: ['./profiles.component.css']
})
export class ProfilesComponent implements OnInit {
  @Input() aboutMe?: AboutMe;
  message:string="";


  constructor(
    private route: ActivatedRoute, 
    private userServ: UserService,
    private location: Location
  ) { }

  ngOnInit(): void {
  }

  goBack(): void {
    this.location.back();
  }
  async updateAboutMe(aboutme: AboutMe): Observable<any> {
    if (this.userServ.loggedInUser && (this.aboutMe.user = this.userServ.loggedInUser)) {
      let success = await this.updateAboutMe(this.aboutMe);
      if (success) {
      this.aboutMe.age =  this.aboutMe.age;
      this.aboutMe.certs = this.aboutMe.certs;
      this.aboutMe.description = this.aboutMe.description;
      this.aboutMe.experience = this.aboutMe.experience;
      this.aboutMe.media = this.aboutMe.media;
      this.message = "AboutMe Updated";
    } else this.message = 'Something went wrong. Please try again later.';
    } else {
      this.message = 'You have to be logged in to edit user profile!';
    }
  }
}

