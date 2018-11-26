import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { NgForm } from '@angular/forms';
import { Board } from '../../model/board';
import { BoardHttpService } from '../../http/board-http.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.scss']
})
export class UpdateComponent implements OnInit {
  board: Board = {
    id: 0,
    writer: '',
    title: '',
    content: '',
    regDate: '',
    hitCount: 0
  };
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

  submitForm(f: NgForm) {
    console.log(this.board);

    this.boardHttpService.putBoard(this.board)
      .then(data => { // always executed
        this.router.navigate(['/boards']);
      }).catch(error => { // handle error

      });
  }

}
