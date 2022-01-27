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
    // this.getAboutMes();
    this.aboutMes = await this.aboutMeServ.getAboutMes();
    console.log(this.aboutMes);
    // this.userServ.checkLogin().then(resp => {
    //   this.user=this.userServ.loggedInUser;
    //   console.log(this.user);
    // });
  }

  // getAboutMes(): void {
  //   this.aboutMeServ.getAboutMes()
  //   .subscribe(aboutMes => this.aboutMes =  aboutMes);
  // }
  // async getAboutMes(): Promise<void> {
  //   this.aboutMes = await this.aboutMeServ.getAboutMes();
  // }

  goBack(): void {
    this.location.back();
  }

} 

