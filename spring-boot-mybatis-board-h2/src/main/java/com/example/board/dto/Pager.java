package com.example.board.dto;

import lombok.Data;

// 페이징 처리를 위한 정보를 컨트롤러에서 뷰에게 전달하는 용도의 클래스
@Data
public class Pager {
	private int page; // current page: 현재 페이지(사용자가 보고싶은 페이지)
	private int size; // rows per page: 페이지당 표시해야 하는 로우의 개수
	private int bsize; // pages per block: 하단에 표시해야 하는 페이징 넘버의 개수

	private int rows; // total elements: 테이블의 갖고 있는 모든 로우의 개수
	private int pages; // total pages: 전체 페이지 수
	private int blocks; // total blocks: 전체 블럭 수 

	private int block; // current block: 현재 블럭 번호
	private int bspage; // current block start page: 현재 블럭에서 시작 페이지 번호
	private int bepage; // current block end page: 현재 블럭에서 끝 페이지 번호

	public Pager(int page, int size, int bsize, int rows) {
		this.page = page;
		this.size = size;
		this.bsize = bsize;
		this.rows = rows;

		pages = (int) Math.ceil((double) this.rows / this.size);
		blocks = (int) Math.ceil((double) pages / this.bsize);

		block = (int) Math.ceil((double) this.page / this.bsize);
		bepage = block * this.bsize;
		bspage = bepage - this.bsize + 1;
	}
}
