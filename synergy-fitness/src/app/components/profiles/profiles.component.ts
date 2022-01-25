import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profiles',
  templateUrl: './profiles.component.html',
  styleUrls: ['./profiles.component.css']
})
export class ProfilesComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  async UpdateAboutMe() {
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

}
