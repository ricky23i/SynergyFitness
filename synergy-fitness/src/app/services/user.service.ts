import { Injectable } from '@angular/core';
import { Person } from '../models/person';
import { UrlService } from './url.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  loggedInUser:Person;
  authHeaders = {'Content-type':'application/json','Token':''};
  regHeaders = {'Content-type':'application/json'};

  constructor(private url:UrlService) { }


  async checkLogin() {
    let token = localStorage.getItem('Token');
    if (token) {
      let resp = await fetch(this.url.url + 'users/' + token + '/auth');
      if (resp.status===200) {
        this.loggedInUser = await resp.json();
      }
    }
  }

  async logIn(username:string,password:string): Promise<void> {
    let credentials = {
      'username':username,
      'password':password
    };

    let resp = await fetch(this.url.url + 'users/auth', {method:'POST',body:JSON.stringify(credentials),
      headers:this.regHeaders});

    if (resp.status===200) {
      let token = await resp.json();
      localStorage.setItem('Token', token);
      //console.log("logged in success");
      
    }
  }

  logOut(): void {
    localStorage.clear();
    this.loggedInUser = null;
  }

  async register(person:Person): Promise<void> {
    let resp = await fetch(this.url.url + 'users', {method:'POST',body:JSON.stringify(person),
      headers:this.regHeaders});
    if (resp.status===200 || resp.status===201) {
      // TODO
    }
  }

  async updateUser(person:Person): Promise<void> {
    if (person.id===this.loggedInUser.id) {
      this.authHeaders.Token = localStorage.getItem('Token');
      let resp = await fetch(this.url.url + 'users/' + person.id, {method:'PUT',body:JSON.stringify(person),
        headers:this.authHeaders});
      if (resp.status===200) {
        this.loggedInUser = await resp.json();
      }
    }
  }
}
