import { Component, OnInit } from '@angular/core';
import { Person } from 'src/app/models/person';
import { Post } from 'src/app/models/post';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-create-post',
  templateUrl: './create-post.component.html',
  styleUrls: ['./create-post.component.css']
})
export class CreatePostComponent implements OnInit {
selectedImageFile
newpost:Post;
message:string="";
user:Person;

  constructor(public userServ:UserService) { }

  ngOnInit(): void {
    this.userServ.checkLogin().then(resp => {
        this.user=this.userServ.loggedInUser;
        console.log(this.user);
      });

  }

  onPhotoSelected(photoSelector: HTMLInputElement){
   this.selectedImageFile = photoSelector.files[0];
   if(!this.selectedImageFile) return;
   let fileReader = new FileReader();
   fileReader.readAsDataURL(this.selectedImageFile);
   fileReader.addEventListener(
    "loadend",
    ev => {
     let readableString = fileReader.result.toString();
     let postPreviewImage = <HTMLImageElement>document.getElementById("post-preview-image");
     postPreviewImage.src = readableString;
    }

   )
  }

async addPost(){
    if(this.userServ.loggedInUser){
        this.newpost=this.user.post;
        this.newpost.postId=this.user.post.postId;
        this.newpost.postData=this.newpost.postData + ":" + (<HTMLInputElement>document.getElementById("wrkout")).value;
        this.user.newpost.postData=this.newpost;
        console.log(this.newpost.postData);
        let success = await this.userServ.updateUser(this.user);
        this.message="Post Uploaded";
    }

}
}


