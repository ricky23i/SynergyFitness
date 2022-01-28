import { Component, ComponentFactoryResolver, Input, OnInit } from '@angular/core';
import { Person } from 'src/app/models/person';
import { Post } from 'src/app/models/post';
import { UserService } from 'src/app/services/user.service';
import { Location } from '@angular/common';
import { MediaService } from 'src/app/services/media.service';
import { HttpEvent, HttpEventType } from '@angular/common/http';

@Component({
  selector: 'app-create-post',
  templateUrl: './create-post.component.html',
  styleUrls: ['./create-post.component.css']
})
export class CreatePostComponent implements OnInit {
  selectedImageFile: File;
  newpost: Post = new Post(0, null, " ", null);
  message: string = "";
  user: Person;

  progress = { status: '', percentage: 0 };

  constructor(public userServ: UserService,
    private mediaService:MediaService,
    private location: Location) { }

  ngOnInit(): void {
    this.userServ.checkLogin().then(resp => {
      this.user = this.userServ.loggedInUser;
      console.log(this.user);
      console.log(this.user.role);
    });
  }

  onPhotoSelected(photoSelector: HTMLInputElement) {
    this.selectedImageFile = photoSelector.files[0];
    if (!this.selectedImageFile) return;
    let fileReader = new FileReader();
    fileReader.readAsDataURL(this.selectedImageFile);
    fileReader.addEventListener("loadend",
      ev => {
        let readableString = fileReader.result.toString();
        let postPreviewImage = <HTMLImageElement>document.getElementById("post-preview-image");
        postPreviewImage.src = readableString;
      }
    )
  }

  async addPost() {
    if (this.userServ.loggedInUser) {
      this.newpost.user = this.user;
      this.newpost.postData = (<HTMLInputElement>document.getElementById("wrkout222")).value;
      console.log(this.newpost);
      let success = await this.userServ.addPost(this.newpost);
      this.message = "Post Uploaded";
    }
    this.refreshPage();
  }

  refreshPage(): void {
    location.reload();
  }

  uploadMedia() {
    const formData = new FormData();

    formData.append('files', this.selectedImageFile, this.selectedImageFile.name);
    this.mediaService.upload(formData).subscribe(
      event => {
        this.reportProgress(event);
      }
    );
  }

  reportProgress(event: HttpEvent<string[]>) {
    switch(event.type) {
      case HttpEventType.UploadProgress:
        this.updateStatus(event.loaded, event.total);
        break;
      case HttpEventType.Response:
        console.log(event.body);
        console.log('Uploaded!');

        for(const media of event.body) {
          this.newpost.media_url = media['mediaUrl'];
        }
        this.addPost()
        break;
    }
  }

  updateStatus(loaded: any, total: any) {
    this.progress.status = 'uploading'
    this.progress.percentage = Math.round((loaded / total) * 100);
  }
}


