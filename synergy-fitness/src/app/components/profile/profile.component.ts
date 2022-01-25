import { Component, Input, OnInit } from '@angular/core';

import { AboutMe } from '../../models/about-me';
import { UserService } from '../../services/user.service';
import { ProfileService } from 'src/app/services/profile.service';


@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  aboutMes = AboutMe[] = [];

  constructor(private profileService: ProfileService) { }

  ngOnInit(): void {
    this.getAboutMes();
  }

getAboutMes(): void {
  this.profileService.getAboutMes()
  .subscribe(aboutMes => this.aboutMes = aboutMes)
}

} 
