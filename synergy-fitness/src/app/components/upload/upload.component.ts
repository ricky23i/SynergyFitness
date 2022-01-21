import { HttpErrorResponse, HttpEvent, HttpEventType } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { MediaService } from '../services/media.service';


@Component({
  selector: 'app-upload',
  templateUrl: './upload.component.html',
  styleUrls: ['./upload.component.css']
})
export class UploadComponent implements OnInit {

  filename: string = '';
  status: string = '';

  constructor(private mediaService: MediaService) { }
  ngOnInit(): void {
  }

  onUploadMedia(file: File): void {
    const formData = new FormData();

    formData.append('file', file, file.name);
    this.mediaService.upload(formData).subscribe(
      event => {
        console.log(event);
        this.reportProgress(event);
      },
      (error: HttpErrorResponse) => {
        console.log(error);
      }
    );
  }
  reportProgress(event: HttpEvent<string>): void {
    // throw new Error('Method not implemented.');
    switch(event.type) {
      case HttpEventType.UploadProgress:
        this.updateStatus(event.loaded, event.total, 'Uploading...');
        break;
      case HttpEventType.ResponseHeader:
        console.log('Header ', event);
        this.status = event.statusText;
        break;
      case HttpEventType.Response:
        console.log(event.body);
        if(event.body) {
          this.filename = event.body;
        }
    }
  }
  updateStatus(loaded: number, total: number | undefined, arg2: string) {
    throw new Error('Method not implemented.');
  }

}
