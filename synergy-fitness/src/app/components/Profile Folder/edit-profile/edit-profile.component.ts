import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

import { AboutMe } from 'src/app/models/about-me';
import { Person } from 'src/app/models/person';
import { UserService } from 'src/app/services/user.service';
import { AboutMeService } from 'src/app/services/about-me.service';

@Component({
  selector: 'app-edit-profile',
  templateUrl: './edit-profile.component.html',
  styleUrls: ['./edit-profile.component.css']
})
export class EditProfileComponent implements OnInit {
  @Input() editAboutMe: AboutMe;
  user:Person;

  constructor(
    private route: ActivatedRoute, 
    private userServ: UserService,
    private aboutMeServ: AboutMeService,
    private location: Location,
  ) { }

  ngOnInit(): void {
    // if (this.userServ.loggedInUser.id === this.editAboutMe.user.id)
    this.viewAboutMe();

    this.userServ.checkLogin().then(resp => {
      this.user=this.userServ.loggedInUser;
      console.log(this.user);
    });
  }

  async viewAboutMe() { 
    if (this.editAboutMe.aboutMeId) {
      console.log(this.editAboutMe);
      let aboutMe = await this.aboutMeServ.getAboutMe(this.editAboutMe.aboutMeId);
      if (aboutMe) this.editAboutMe = aboutMe;
    }
  }

  async save(){
    if (this.userServ.loggedInUser.id = this.editAboutMe.user.id){
      let success = await this.aboutMeServ.updateAboutMe(this.editAboutMe);
    }
  }

}
