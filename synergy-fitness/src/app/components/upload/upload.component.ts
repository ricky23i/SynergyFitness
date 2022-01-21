
import { HttpErrorResponse, HttpEvent, HttpEventType, HttpResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { MediaService } from '../../services/media.service';

@Component({
  selector: 'app-upload',
  templateUrl: './upload.component.html',
  styleUrls: ['./upload.component.css']
})
export class UploadComponent implements OnInit {
  onFileSelected(event) {
    console.log(event);

  }

  onUploadMedia(files: File[]): void {
    const formData = new FormData();

    for(const file of files) {
      formData.append('files', file, file.name);
    }

    this.mediaService.upload(formData).subscribe(
        event => {
          console.log(event);
          this.reportProgress(event);
        }
    );

    // formData.append('file', file, file.name);
    // this.mediaService.upload(formData).subscribe(
    //   event => {
    //     console.log(event);
    //     this.reportProgress(event);
    //   },
    //   (error: HttpErrorResponse) => {
    //     console.log(error);
    //   }
    // );
  }
  reportProgress(event: HttpEvent<string[]>): void {
    // throw new Error('Method not implemented.');
    switch(event.type) {
      case HttpEventType.UploadProgress:
        this.updateStatus(event.loaded, event.total);
        break;
      case HttpEventType.Response:
        console.log(event.body);
        for(const filename of event.body) {
          this.filenames.unshift(filename);
        }
        break;
    }
  }
  updateStatus(loaded: number, total: number) {
    // throw new Error('Method not implemented.');
    this.fileProgress.status = 'uploading';
    this.fileProgress.percentage = Math.round((loaded / total) * 100);

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
