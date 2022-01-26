import { Component, OnInit } from '@angular/core';
import { MatDialog} from '@angular/material/dialog';
import { CreatePostComponent } from 'src/app/tools/create-post/create-post.component';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {

  constructor(private dialog: MatDialog) { }

  ngOnInit(): void {
  }

  onCreatePostClick(){
    this.dialog.open(CreatePostComponent);
  }

}