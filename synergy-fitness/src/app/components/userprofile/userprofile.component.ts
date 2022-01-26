import { Component, OnInit } from '@angular/core';
import { Person } from 'src/app/models/person';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-userprofile',
  templateUrl: './userprofile.component.html',
  styleUrls: ['./userprofile.component.css']
})
export class UserprofileComponent implements OnInit {
  user:Person;
  showError:boolean;
  constructor(public userServ:UserService) { }

  ngOnInit(): void {
 this.setUp();
   }
  async updatePerson(){
    if (this.userServ.loggedInUser){
      let success = await this.userServ.updateUser(this.user);
     if(success) this.setUp();
     else this.showError=false;
    }

  }
  setUp(){
    this.showError = false;
     this.userServ.checkLogin().then(resp => {
       this.user=this.userServ.loggedInUser;
     });
  }
}
