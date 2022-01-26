import { Component, OnInit } from '@angular/core';
import { MaterialModule } from 'src/app/material/material.module';
import { PostComponent} from '../post/post.component';
import { MatDialog } from '@angular/material/dialog';
import { Post } from 'src/app/models/post';
import { Person } from 'src/app/models/person';
import { UserService } from 'src/app/services/user.service';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  getpost:Post;
  user:Person;
  message:string="";
  posts:Post[];

  constructor(
    private dialog: MatDialog,
    public userServ:UserService
    ) { }

  ngOnInit(): void {
    this.userServ.checkLogin().then(resp => {
      this.user=this.userServ.loggedInUser;
      console.log(this.user);
    });

    this.getPosts();
  }

  async getPosts(){
    if(this.userServ.loggedInUser){
        this.posts = await this.userServ.getPosts();
        this.message="Retreieved posts";
        console.log(this.posts);

    }
  }
 

}
