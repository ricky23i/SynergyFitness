import { HttpClient, HttpEvent } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MediaService {

  private BASE_URL = 'http://localhost:4200';
  private MEDIA_URL = this.BASE_URL + '/media/upload'

  constructor(private http: HttpClient) { }

  upload(formData: FormData): Observable<HttpEvent<string[]>> {
    return this.http.post<string[]>(this.MEDIA_URL, formData,
      {
        reportProgress: true,
        observe: 'events'
      });
  }
}
