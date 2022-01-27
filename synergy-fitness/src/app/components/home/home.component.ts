import { Component, Input, OnInit } from '@angular/core';
import { MaterialModule } from 'src/app/material/material.module';
import { PostComponent} from '../post/post.component';
import { MatDialog } from '@angular/material/dialog';
import { Post } from 'src/app/models/post';
import { Person } from 'src/app/models/person';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  @Input() post:Post;
  constructor(private dialog: MatDialog) { }

  ngOnInit(): void {}
  

  
 

}
