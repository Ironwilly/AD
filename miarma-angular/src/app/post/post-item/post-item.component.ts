import { Input } from '@angular/core';
import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { PostResponse } from 'src/app/models/interfaces/post.interface';
import { AuthService } from 'src/app/services/auth.service';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-post-item',
  templateUrl: './post-item.component.html',
  styleUrls: ['./post-item.component.css']
})
export class PostItemComponent implements OnInit {
  @Input() postInput!: PostResponse;

  constructor(private authService: AuthService,
    private dialog: MatDialog

  ) { }

  ngOnInit(): void {
  }

  getPostImageUrl(post: PostResponse) {
    return `${environment.apiBaseUrl}${post.imagen}`;
  }

}
