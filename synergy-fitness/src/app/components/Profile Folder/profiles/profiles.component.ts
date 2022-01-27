import { Component, Input, OnInit } from '@angular/core';
import { Location } from '@angular/common';

import { AboutMe } from '../../../models/about-me';
import { Person } from 'src/app/models/person';
import { UserService } from '../../../services/user.service';
import { AboutMeService } from 'src/app/services/about-me.service';



@Component({
  selector: 'app-profiles',
  templateUrl: './profiles.component.html',
  styleUrls: ['./profiles.component.css']
})
export class ProfilesComponent implements OnInit {
  aboutMes: AboutMe[];

  constructor(
    private aboutMeServ: AboutMeService,
    public userServ: UserService,
    private location: Location
     ) { }

  async ngOnInit(): Promise<void> {
    this.aboutMes = await this.aboutMeServ.getAboutMes();
    console.log(this.aboutMes);
  }

  goBack(): void {
    this.location.back();
  }

} 

