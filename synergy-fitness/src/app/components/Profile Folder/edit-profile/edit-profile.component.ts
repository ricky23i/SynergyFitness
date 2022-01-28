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
  editAboutMe: AboutMe;
  user:Person;
  showError:Boolean;
  showSuccess:Boolean;
  constructor(
    private route: ActivatedRoute, 
    private userServ: UserService,
    private aboutMeServ: AboutMeService,
    private location: Location,
  ) { }

  ngOnInit(): void {
    // if (this.userServ.loggedInUser.id === this.editAboutMe.user.id)
    // this.viewAboutMe();
    this.setup();

    this.userServ.checkLogin().then(resp => {
      this.user=this.userServ.loggedInUser;
    });
  }

  async viewAboutMe() { 
    if (this.editAboutMe.aboutMeId && this.editAboutMe.aboutMeId>0) {
      let editaboutMe = await this.aboutMeServ.getAboutMe(this.editAboutMe.aboutMeId);
      if (editaboutMe) this.editAboutMe = editaboutMe;
      else this.editAboutMe = new AboutMe(0,null,'',null,0,'','');
    }
  }

  async save(){
    if (this.userServ.loggedInUser.id === this.editAboutMe.user.id){
      let success = await this.aboutMeServ.updateAboutMe(this.editAboutMe)
      if (!success) this.setup();
      this.showSuccess=true;
    } else this.showError=true;
  }

  setup() {
    this.editAboutMe = new AboutMe(0,null,'',null,0,'','');
    this.showError = false;
  }

}
