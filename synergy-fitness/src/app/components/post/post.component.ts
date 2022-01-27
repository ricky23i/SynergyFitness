import { Component, Input, OnInit } from '@angular/core';
import { MatDialog} from '@angular/material/dialog';
import { Post } from 'src/app/models/post';
import { CreatePostComponent } from 'src/app/tools/create-post/create-post.component';
import { UserService } from 'src/app/services/user.service';
import { Person } from 'src/app/models/person';

@Component({
selector: 'app-post',
templateUrl: './post.component.html',
 styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {
    posts:Post[];
        user: Person;
        message:string="";
constructor(
    public userServ:UserService,
    private dialog: MatDialog) { }

 async ngOnInit(): Promise<void> {
    
    this.posts= await this.userServ.getPosts();
    }
 onCreatePostClick(){
     this.dialog.open(CreatePostComponent);
    }



}