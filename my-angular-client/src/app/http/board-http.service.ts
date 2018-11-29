import { Injectable } from '@angular/core';
import axios from 'axios';
import { Board } from '../model/board';

@Injectable({
  providedIn: 'root'
})
export class BoardHttpService {
  URL: string = 'http://localhost:8080/boards';

  constructor() { }

  getBoards(page, size, bsize) {
    return axios.get(this.URL + '?page=' + page + '&size=' + size + '&bsize=' + bsize)
      .then(function(response) {
        return response.data;
      });
  }

  getBoard(id: number) {
    return axios.get(this.URL + '/' + id)
      .then(function(response) {
        console.log(response);
        return response.data;
      });
  }

  postBoard(board: Board) {
    return axios.post(this.URL, board)
      .then(function(response) {
        console.log(response);
        return response.data;
      });
  }

  putBoard(board: Board) {
    return axios.put(this.URL + '/' + board.id, board)
      .then(function(response) {
        console.log(response);
        return response.data;
      });
  }

  deleteBoard(id: number) {
    return axios.delete(this.URL + '/' + id)
      .then(function(response) {
        console.log(response);
        return true;
      });
  }
}
