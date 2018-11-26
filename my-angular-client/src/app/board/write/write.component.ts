import { Component, OnInit } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { NgForm } from '@angular/forms';
import { Board } from '../../model/board';
import { BoardHttpService } from '../../http/board-http.service';

@Component({
  selector: 'app-write',
  templateUrl: './write.component.html',
  styleUrls: ['./write.component.scss']
})
export class WriteComponent implements OnInit {
  board: Board = {
    id: 0,
    writer: '',
    title: '',
    content: '',
    regDate: '',
    hitCount: 0
  };

  constructor(private boardHttpService: BoardHttpService, private router: Router) { }

  ngOnInit() {
  }

  submitForm(f: NgForm) {
    console.log(this.board);

    this.boardHttpService.postBoard(this.board)
      .then(data => { // always executed
        this.router.navigate(['/boards']);
      }).catch(error => { // handle error

      });
  }

}
