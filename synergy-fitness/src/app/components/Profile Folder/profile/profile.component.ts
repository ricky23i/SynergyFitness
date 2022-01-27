import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

import { AboutMe } from 'src/app/models/about-me';
import { Person } from 'src/app/models/person';
import { UserService } from 'src/app/services/user.service';
import { AboutMeService } from 'src/app/services/about-me.service';

@Component({
  selector: 'app-profile',
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
    console.log(this.aboutMe);
    this.viewAboutMe();

    this.userServ.checkLogin().then(resp => {
      this.user=this.userServ.loggedInUser;
    });
  }

  async viewAboutMe() { 
    if (this.aboutMe.aboutMeId) {
      let aboutMe = await this.aboutMeServ.getAboutMe(this.aboutMe.aboutMeId);
      if (aboutMe) this.aboutMe = aboutMe;
    }
  }


  goBack(): void {
    this.location.back();
  }
}

