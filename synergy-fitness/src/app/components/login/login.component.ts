import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { UserService } from '../../services/user.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  @Output() login: EventEmitter<any> = new EventEmitter();
  usernameInput:string;
  passwordInput:string;

  constructor(private userServ:UserService) { }

  ngOnInit(): void {
  }

  logIn() {
    this.userServ.logIn(this.usernameInput,this.passwordInput).then(resp => {
      this.login.emit();
      location.reload();
    });
  }

}
