import { HttpClient, HttpEvent } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Media } from '../models/media';
import { Person } from '../models/person';
import { UrlService } from './url.service';

@Injectable({
  providedIn: 'root'
})
export class MediaService {
  loggedInUser:Person;
  authHeaders = {'Content-type':'application/json','Token':''};
  regHeaders = {'Content-type':'application/json'};

  private mediaUrl: string;
  private saveUrl: string;
  private userUrl: string;

  constructor(private http: HttpClient, private urlService:UrlService) {
    this.mediaUrl = urlService.url + 'media/upload';
    this.saveUrl = urlService.url + 'media/saveinfo';
    this.userUrl = urlService.url + 'users/';
   }

  upload(formData: FormData): Observable<HttpEvent<string[]>> {
    return this.http.post<string[]>(this.mediaUrl, formData,
      {
        reportProgress: true,
        observe: 'events'
      });
  }

  async saveInfo(media:any): Promise<void> {
    let response = await fetch(this.saveUrl, {
      method:'POST',
      body: JSON.stringify(media),
      headers: this.regHeaders
     });
     if (response.status===200 || response.status===201) {
      // TODO
      console.log(media.fileName + ' Saved!');

    }
  }

  async checkLogin() {
    let token = localStorage.getItem('Token');
    if (token) {
      let resp = await fetch(this.userUrl + token + '/auth' );
      if (resp.status===200) {
        this.loggedInUser = await resp.json();
      }
    }
  }
}
