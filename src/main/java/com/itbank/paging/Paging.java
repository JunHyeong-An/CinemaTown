package com.itbank.paging;


public class Paging {

	private final int perPage = 10;		// 페이지마다 나타낼수있는 글의 수
	private int pageCount;				// 총 페이지의 개수
	private int boardCount;				// 총 게시글 개수
	private int offset;					// 건너뛸 게시글의 개수
	private int page;					 

	private final int perSection = 10;	// 게시글 밑에 페이징 개수
	private int begin;					// 시작 페이지
	private int end;					// 끝 페이지
	private int section;				// 현재 페이지가 속하는 페이징 번호의 섹션 (1~10, 11~20)

	private boolean prev;				// 이전
	private boolean next;				// 다음

	public Paging(int page, int boardCount) { // 요청받은 페이지 번호와 총 게시글 수를 전달받는다
		this.page = page;
		this.boardCount = boardCount;
		pageCount = boardCount / perPage; // 총 페이지의 개수
		pageCount += (boardCount % perPage == 0) ? 0 : 1; // 나머지가 있으면 +1

		offset = (page - 1) * perPage; // 건너뛸 게시글의 개수

		section = (page - 1) / perSection; 	// 현재 페이지가 속하는 페이징 번호의 섹션 (1~10, 11~20)
		begin = perSection * section + 1; 	// 11, 21, 31...
		end = begin + perSection - 1; 		// 20, 30, 40...
		end = end > pageCount ? pageCount : end;// 만약 총 페이지 수가 부족하면 마지막 페이지까지만 (ex. 38)

		prev = section != 0; 				// 현재 섹션이 0번 섹션이면 이전 페이지는 존재하지 않는다
		next = boardCount > perPage * end; 	// 총 게시글이 현재 마지막 섹션 수 * 화면당 게시글 수와 비교하여 적으면 다음이 없다
		System.out.println(this.begin);
		System.out.println(this.end);
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getBoardCount() {
		return boardCount;
	}

	public void setBoardCount(int boardCount) {
		this.boardCount = boardCount;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getBegin() {
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getSection() {
		return section;
	}

	public void setSection(int section) {
		this.section = section;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getPerPage() {
		return perPage;
	}

	public int getPerSection() {
		return perSection;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}
}
