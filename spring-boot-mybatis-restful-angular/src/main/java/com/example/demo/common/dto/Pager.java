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
	private int elementsPerPage; // 페이지당 표시하는 로우의 개수
	private int pagesPerBlock; // 하단에 표시하는 페이징 넘버의 개수
	private int totalElements; // 테이블이 갖고 있는 모든 로우의 개수
	
	private int totalPages; // 전체 페이지 수
	private int totalBlocks; // 전체 블럭 수 

	private int currentBlock; // 현재 블럭
	private int currentBlockStartPage; // 현재 블럭의 시작 페이지 번호
	private int currentBlockEndPage; // 현재 블럭의 끝 페이지 번호
	
	private List<String> pagination = new ArrayList<>();
	
	private int beforePage;
	private int nextPage;
	
	private List<Path> paths = new ArrayList<>();

	public Pager(int page, int rows, final String url) {
		this(page, 20, 10, rows, url);
	}
	
	public Pager(int page, int rows, HttpServletRequest req) {
		this(page, 20, 10, rows, req.getRequestURI());
	}
	
	public Pager(int page, int size, int bsize, int rows, HttpServletRequest req) {
		this(page, size, bsize, rows, req.getRequestURI());
	}
	
	public Pager(int page, int size, int bsize, int rows, final String url) {
		currentPage = page;
		if (currentPage <= 0) {
			currentPage = 1;
		}
		elementsPerPage = size;
		if (elementsPerPage <= 0) {
			elementsPerPage = 1;
		}
		pagesPerBlock = bsize;
		if (pagesPerBlock <= 0) {
			pagesPerBlock = 1;
		}
		totalElements = rows;

		totalPages = (int) Math.ceil((double) totalElements / elementsPerPage);
		totalBlocks = (int) Math.ceil((double) totalPages / pagesPerBlock);
		
		currentBlock = (int) Math.ceil((double) currentPage / pagesPerBlock);
		currentBlockEndPage = currentBlock * pagesPerBlock;
		currentBlockStartPage = currentBlockEndPage - pagesPerBlock + 1;
		
		proceedPagination(url);
		
		/*
		 * For Simple Paging with 2 Buttons (Before, Next)
		 */
		beforePage = currentPage - 1;
		if (beforePage < 0) {
			beforePage = 0;
		}
		nextPage = currentPage + 1;
		if (nextPage > totalPages) {
			nextPage = 0;
		}
		
		proceedPath(url);
	}
	
	public void addPageLink(String link) {
		pagination.add(link);
	}
	
	public void addPaths(Path path) {
		paths.add(path);
	}
	
	/**
	 * For JSP, Vue.js
	 */
	public void proceedPagination(final String url) {
		
		final String COMMON_QUERY = "&size="+elementsPerPage+"&bsize="+pagesPerBlock;
		
		if (totalElements > 0) {
			// 로우가 있을 때
			
			if (currentBlockStartPage > pagesPerBlock) {
				// Home 버튼
				String params = "page=1"+COMMON_QUERY;
				String link = "<a href='"+url+"?"+params+"'>Home</a>";
				addPageLink(link);
				
				// 이전 블럭
				params = "page="+(currentBlockStartPage-1)+COMMON_QUERY;
				link = "<a href='"+url+"?"+params+"'>&laquo;</a>";
				addPageLink(link);
			}
			
			// Paging 버튼
			for (int pno = currentBlockStartPage; pno <= currentBlockEndPage; pno++) {
				
				String link = null;
				if (pno == currentPage) {
					link = "<a href>"+pno+"</a>";
					addPageLink(link);
				} else {
					if (pno <= totalPages) {
						String params = "page="+pno+COMMON_QUERY;
						link = "<a href='"+url+"?"+params+"'>"+pno+"</a>";
						addPageLink(link);
					}
				}
			}
			
			if (currentBlockEndPage < totalPages) {
				// 이후 블럭
				String params = "page="+(currentBlockEndPage+1)+COMMON_QUERY;
				String link = "<a href='"+url+"?"+params+"'>&raquo;</a>";
				addPageLink(link);
				
				// Last 버튼
				params = "page="+totalPages+COMMON_QUERY;
				link = "<a href='"+url+"?"+params+"'>Last</a>";
				addPageLink(link);
			}
			
		} else {
			// 로우가 없을 때
			
			String link = "<a href>1</a>";
			addPageLink(link);
		}

	}
	
	/**
	 * For Angular
	 */
	@Data
	public static class Param {
		private int page;
		private int size;
		private int bsize;
		
		public Param(int page, int size, int bsize) {
			super();
			this.page = page;
			this.size = size;
			this.bsize = bsize;
		}
		
	}
	
	@Data
	public static class Path {
		private String active;
		private String link;
		private Param params;
		private String text;
		
		public Path(String active, String link, Param params, String text) {
			this.active = active;
			this.link = link;
			this.params = params;
			this.text = text;
		}
	}
	
	private void proceedPath(String url) {
		
		if (totalElements > 0) {
			// 로우가 있을 때
			
			if (currentBlockStartPage > pagesPerBlock) {
				// Home 버튼
				addPaths(new Path("", url, new Param(1, elementsPerPage, pagesPerBlock), "Home"));
				
				// 이전 블럭
				addPaths(new Path("", url, new Param(currentBlockStartPage-1, elementsPerPage, pagesPerBlock), "<<"));
			}
			
			// Paging 버튼
			for (int pno = currentBlockStartPage; pno <= currentBlockEndPage; pno++) {
				
				if (pno == currentPage) {
					addPaths(new Path("active", url, new Param(pno, elementsPerPage, pagesPerBlock), String.valueOf(pno)));
				} else {
					if (pno <= totalPages) {
						addPaths(new Path("", url, new Param(pno, elementsPerPage, pagesPerBlock), String.valueOf(pno)));
					}
				}
			}
			
			if (currentBlockEndPage < totalPages) {
				// 이후 블럭
				addPaths(new Path("", url, new Param(currentBlockEndPage+1, elementsPerPage, pagesPerBlock), ">>"));
				
				// Last 버튼
				addPaths(new Path("", url, new Param(totalPages, elementsPerPage, pagesPerBlock), "Last"));
			}
			
		} else {
			// 로우가 없을 때
			
			addPaths(new Path("", url, new Param(1, elementsPerPage, pagesPerBlock), "1"));
		}
		
	}
	
}
