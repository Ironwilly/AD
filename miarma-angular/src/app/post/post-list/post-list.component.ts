import { Component, OnInit } from '@angular/core';
import { PostResponse } from 'src/app/models/interfaces/post.interface';
import { AuthService } from 'src/app/services/auth.service';
import { PostService } from 'src/app/services/post.service';

@Component({
  selector: 'app-post-list',
  templateUrl: './post-list.component.html',
  styleUrls: ['./post-list.component.css']
})
export class PostListComponent implements OnInit {
  postList: PostResponse[] = [];

  constructor(private postService: PostService,private authService: AuthService) { }

  ngOnInit(): void {
    this.postService.getPost().subscribe(postResponse =>{

      this.postList = postResponse;})  // esta linea esta bien, hay que mirar el porqué falla
    }

    
  }


