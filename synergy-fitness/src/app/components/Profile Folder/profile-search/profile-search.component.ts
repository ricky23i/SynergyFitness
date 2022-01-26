import { Component, OnInit } from '@angular/core';

import { Observable, Subject } from 'rxjs';

import {
  debounceTime, distinctUntilChanged, switchMap
} from 'rxjs/operators';

import { AboutMe } from 'src/app/models/about-me';
import { Person } from 'src/app/models/person';
import { AboutMeService } from 'src/app/services/about-me.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-profile-search',
  templateUrl: './profile-search.component.html',
  styleUrls: ['./profile-search.component.css']
})
export class ProfileSearchComponent implements OnInit {
  aboutMes$!: Observable<AboutMe[]>;
  private searchTerms = new Subject<string>();

  constructor(private aboutMeService: AboutMeService, public userService: UserService) { }

  search(term: string): void {
    this.searchTerms.next(term);
  }

  ngOnInit(): void {
    this.aboutMes$ = this.searchTerms.pipe(
      // wait 300ms after each keystroke before considering the term
      debounceTime(300),

      // ignore new term if same as previous term
      distinctUntilChanged(),

      // switch to new search observable each time the term changes
      switchMap((term: string) => this.aboutMeService.searchAboutMe(term)),
    );
  }
}