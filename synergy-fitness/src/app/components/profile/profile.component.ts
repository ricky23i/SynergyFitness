import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

import { AboutMe } from 'src/app/models/about-me';
import { ProfileService } from 'src/app/services/profile.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-profiles',
  templateUrl: './profiles.component.html',
  styleUrls: ['./profiles.component.css']
})
export class ProfilesComponent implements OnInit {
  @Input() aboutMe?: AboutMe;

  constructor(
    private route: ActivatedRoute,
    private profilezService: ProfileService, 
    private location: Location
  ) { }

  ngOnInit(): void {
  }

  goBack(): void {
    this.location.back();
  }

save(): void {
  if (this.aboutMe) {
    this.profilezService.updateAboutMe(this.aboutMe)
      .subscribe(() => this.goBack)
  }
}
  }

