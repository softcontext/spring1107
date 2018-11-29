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
  errorMessage = undefined;
  paths: Array<{ active, link, params, text }>;

  constructor(
    private boardHttpService: BoardHttpService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit() {
    /**
     * 초기값
     */
    let page = 1;
    let size = 20;
    let bsize = 10;

    if (this.route.snapshot.queryParamMap.get('page')) {
      page = +this.route.snapshot.queryParamMap.get('page');
    }
    if (this.route.snapshot.queryParamMap.get('size')) {
      size = +this.route.snapshot.queryParamMap.get('size');
    }
    if (this.route.snapshot.queryParamMap.get('bsize')) {
      bsize = +this.route.snapshot.queryParamMap.get('bsize');
    }
    this.findAll(page, size, bsize);
  }

  findAll(page, size, bsize) {
    this.boardHttpService.getBoards(page, size, bsize)
      .then(data => { // always executed
        this.boards = data.boards;
        this.paths = data.pager.paths;
        console.log(this.paths);
      }).catch(error => { // handle error
        console.log(error);
        this.errorMessage = error;
      });
  }

  navigate(path) {
    this.findAll(path.params.page, path.params.size, path.params.bsize);
    // this.router.navigate(['/boards'], { queryParams: path.params });
    return false;
  }
}
