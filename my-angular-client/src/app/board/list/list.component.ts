import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Board } from '../../model/board';
import { BoardHttpService } from '../../http/board-http.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss']
})
export class ListComponent implements OnInit {
  boards: Array<Board> = undefined;
  pagination: string = undefined;
  errorMessage = undefined;

  constructor(
    private boardHttpService: BoardHttpService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit() {
    let page = 1;
    let size = 20;
    let bsize = 10;
    if(this.route.snapshot.queryParamMap.get('page')){
      page = +this.route.snapshot.queryParamMap.get('page');
    }
    if(this.route.snapshot.queryParamMap.get('size')){
      size = +this.route.snapshot.queryParamMap.get('size');
    }
    if(this.route.snapshot.queryParamMap.get('bsize')){
      bsize = +this.route.snapshot.queryParamMap.get('bsize');
    }
    this.findAll(page, size, bsize);
  }

  findAll(page, size, bsize) {
    this.boardHttpService.getBoards(page, size, bsize)
      .then(data => { // always executed
        this.boards = data.boards;
        this.pagination = data.pager.pagination.join('');
      }).catch(error => { // handle error
        console.log(error);
        this.errorMessage = error;
      });
  }

}
