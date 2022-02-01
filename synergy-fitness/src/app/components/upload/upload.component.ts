
import { HttpEvent, HttpEventType } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Media } from 'src/app/models/media';
import { MediaService } from '../../services/media.service';

@Component({
  selector: 'app-upload',
  templateUrl: './upload.component.html',
  styleUrls: ['./upload.component.css']
})
export class UploadComponent implements OnInit {

  filenames: string[] = [];
  // fileProgress: { status: string, percentage: number };
  fileProgress = { status: '', percentage: 0 };

  constructor(private mediaService: MediaService) { }
  ngOnInit(): void { }

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

        for(const media of event.body) {
          // // this.filenames.unshift(filename);
          // let newMedia: Media;
          // newMedia.fileName = media['fileName'];
          // newMedia.mediaUrl = media['mediaUrl'];
          this.mediaService.saveInfo(media)
        }
        break;
    }
  }

  updateStatus(loaded: number, total: number) {
    // throw new Error('Method not implemented.');
    this.fileProgress.status = 'uploading';
    this.fileProgress.percentage = Math.round((loaded / total) * 100);
  }
}
