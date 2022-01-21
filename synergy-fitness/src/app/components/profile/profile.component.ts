
import { Component, Input, OnInit } from '@angular/core';
import { Person } from '../../models/person';
import { AboutMe } from '../../models/about-me';
import { UserService } from '../../services/user.service';


@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  
  @Input() aboutMe:AboutMe;
  message:string = '';

  constructor(private userServ:UserService ) { }

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
