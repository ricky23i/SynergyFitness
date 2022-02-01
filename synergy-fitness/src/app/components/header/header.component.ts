import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";

import { Person } from "../../models/person";
import { UserService } from "../../services/user.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})

export class HeaderComponent implements OnInit{
  loggedInUser:Person;
  showLogin:false;

  constructor(private userServ:UserService, private route:Router) { }

  ngOnInit(): void {
    this.setup();
  }

  setup() {
    this.userServ.checkLogin().then(resp => {
      this.loggedInUser = this.userServ.loggedInUser;
      this.showLogin=false;
    });
  }

  logOut() {
    this.userServ.logOut();
    this.loggedInUser = null;
    this.route.navigate(['/signup']);
  }

}

