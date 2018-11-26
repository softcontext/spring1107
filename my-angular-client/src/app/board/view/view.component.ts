import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { Board } from '../../model/board';
import { BoardHttpService } from '../../http/board-http.service';

@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.scss']
})
export class ViewComponent implements OnInit {
  board: Board = undefined;
  errorMessage = undefined;

  constructor(
    private boardHttpService: BoardHttpService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit() {
    let id = this.route.snapshot.params['id'];
    this.findOne(id);
  }

  findOne(id) {
    this.boardHttpService.getBoard(id)
      .then(data => { // always executed
        this.board = data.board;
      }).catch(error => { // handle error
        this.errorMessage = error;
      });
  }

  delete() {
    this.boardHttpService.deleteBoard(this.board.id)
      .then(data => { // always executed
        // const index = this.emps.findIndex(emp => emp.id == id);
        // this.emps.splice(index, 1);
        console.log(data);
        this.router.navigate(['/boards']);
      }).catch(error => { // handle error
        console.log(error);
        this.errorMessage = error;
      });
  }

}
