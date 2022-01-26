import { Component, ComponentFactoryResolver, OnInit } from '@angular/core';
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
newpost:Post = new Post(1, null, " ");
message:string="";
user:Person;

  constructor(public userServ:UserService) { }

  ngOnInit(): void {
    this.userServ.checkLogin().then(resp => {
        this.user=this.userServ.loggedInUser;
        console.log(this.user);
        console.log(this.user.role);
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
        this.newpost.user=this.user;
        this.newpost.postData= (<HTMLInputElement>document.getElementById("wrkout")).value;
        console.log(this.newpost);
        let success = await this.userServ.addPost(this.newpost);
        this.message="Post Uploaded";
    }

}
}


