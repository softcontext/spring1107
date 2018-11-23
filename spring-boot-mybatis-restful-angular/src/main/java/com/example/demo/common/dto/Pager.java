package com.example.demo.common.dto;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import lombok.Data;

/*
 * 페이징 처리 정보를 컨트롤러에서 뷰에게 전달하는 용도의 클래스
 */
@Data
public class Pager {
	private int currentPage; // 현재 페이지(사용자가 보고싶은 페이지)
	private int elementsPerPage = 20; // 페이지당 표시하는 로우의 개수
	private int pagesPerBlock = 10; // 하단에 표시하는 페이징 넘버의 개수
	private int totalElements; // 테이블이 갖고 있는 모든 로우의 개수
	
	private int totalPages; // 전체 페이지 수
	private int totalBlocks; // 전체 블럭 수 

	private int currentBlock; // 현재 블럭
	private int currentBlockStartPage; // 현재 블럭의 시작 페이지 번호
	private int currentBlockEndPage; // 현재 블럭의 끝 페이지 번호
	
	private List<String> pagination = new ArrayList<>();

	public Pager(int page, int rows, final String url) {
		this.currentPage = page;
		this.totalElements = rows;

		totalPages = (int) Math.ceil((double) this.totalElements / this.elementsPerPage);
		totalBlocks = (int) Math.ceil((double) totalPages / this.pagesPerBlock);
		
		currentBlock = (int) Math.ceil((double) this.currentPage / this.pagesPerBlock);
		currentBlockEndPage = currentBlock * this.pagesPerBlock;
		currentBlockStartPage = currentBlockEndPage - this.pagesPerBlock + 1;
		
		proceed(url);
	}
	
	public Pager(int page, int rows, HttpServletRequest req) {
		this.currentPage = page;
		this.totalElements = rows;
		final String url = req.getRequestURL().toString();

		totalPages = (int) Math.ceil((double) this.totalElements / this.elementsPerPage);
		totalBlocks = (int) Math.ceil((double) totalPages / this.pagesPerBlock);
		
		currentBlock = (int) Math.ceil((double) this.currentPage / this.pagesPerBlock);
		currentBlockEndPage = currentBlock * this.pagesPerBlock;
		currentBlockStartPage = currentBlockEndPage - this.pagesPerBlock + 1;
		
		proceed(url);
	}
	
	public Pager(int page, int size, int bsize, int rows, final String url) {
		this.currentPage = page;
		this.elementsPerPage = size;
		this.pagesPerBlock = bsize;
		this.totalElements = rows;

		totalPages = (int) Math.ceil((double) this.totalElements / this.elementsPerPage);
		totalBlocks = (int) Math.ceil((double) totalPages / this.pagesPerBlock);
		
		currentBlock = (int) Math.ceil((double) this.currentPage / this.pagesPerBlock);
		currentBlockEndPage = currentBlock * this.pagesPerBlock;
		currentBlockStartPage = currentBlockEndPage - this.pagesPerBlock + 1;
		
		proceed(url);
	}
	
	public Pager(int page, int size, int bsize, int rows, HttpServletRequest req) {
		this.currentPage = page;
		this.elementsPerPage = size;
		this.pagesPerBlock = bsize;
		this.totalElements = rows;
		final String url = req.getRequestURL().toString();

		totalPages = (int) Math.ceil((double) this.totalElements / this.elementsPerPage);
		totalBlocks = (int) Math.ceil((double) totalPages / this.pagesPerBlock);
		
		currentBlock = (int) Math.ceil((double) this.currentPage / this.pagesPerBlock);
		currentBlockEndPage = currentBlock * this.pagesPerBlock;
		currentBlockStartPage = currentBlockEndPage - this.pagesPerBlock + 1;
		
		proceed(url);
	}
	
	public void addPageLink(String link) {
		this.pagination.add(link);
	}
	
	public void proceed(final String url) {
		
		final String COMMON = "&size="+elementsPerPage+"&bsize="+pagesPerBlock;
		
		if (totalElements > 0) {
			// 로우가 있을 때
			
			if (currentBlockStartPage > pagesPerBlock) {
				// Home 버튼
				String params = "page=1"+COMMON;
				String link = "<li><a href='"+url+"?"+params+"'>Home</a></li>";
				this.addPageLink(link);
				
				// 이전 블럭
				params = "page="+(currentBlockStartPage-1)+COMMON;
				link = "<li><a href='"+url+"?"+params+"'>&laquo;</a></li>";
				this.addPageLink(link);
			}
			
			// Paging 버튼
			for (int pno = currentBlockStartPage; pno <= currentBlockEndPage; pno++) {
				
				String link = null;
				if (pno == currentPage) {
					link = "<li class='active'><a href='#'>"+pno+"</a></li>";
					this.addPageLink(link);
				} else {
					if (pno <= totalPages) {
						String params = "page="+pno+COMMON;
						link = "<li><a href='"+url+"?"+params+"'>"+pno+"</a></li>";
						this.addPageLink(link);
					}
				}
			}
			
			if (currentBlockEndPage < totalPages) {
				// 이후 블럭
				String params = "page="+(currentBlockEndPage+1)+COMMON;
				String link = "<li><a href='"+url+"?"+params+"'>&raquo;</a></li>";
				this.addPageLink(link);
				
				// Last 버튼
				params = "page="+totalPages+COMMON;
				link = "<li><a href='"+url+"?"+params+"'>Last</a></li>";
				this.addPageLink(link);
			}
			
		} else {
			// 로우가 없을 때
			
			String link = "<li class='active'><a href='#'>1</a></li>";
			this.addPageLink(link);
		}

	}
	
}
