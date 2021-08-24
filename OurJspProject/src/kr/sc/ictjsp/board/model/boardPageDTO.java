package kr.sc.ictjsp.board.model;

import java.util.List;

public class boardPageDTO {

	private int total;
	private int curPage;
	private List<boardVO> boardList;
	private int tPages;
	private int startPage;
	private int endPage;
	
	public boardPageDTO(int total, int curPage, List<boardVO> boardList) {
	
	this.total = total;
	this.curPage = curPage;
	this.boardList = boardList;
	
	if(total == 0) {
		this.tPages = 0;
		this.startPage = 0;
		this.endPage = 0;
	} else {
		this.tPages = total / 10;
			if(this.total % 10 > 0) {
				this.tPages += 1;
			}
			int modVal = this.curPage % 10;
			this.startPage = this.curPage / 10 * 10 +1;
			if(modVal == 0) {
				this.startPage -= 10;
			}
			endPage = startPage + (10 - 1);
	if(endPage > tPages) {
		endPage = tPages;
			}
		}
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public List<boardVO> getBoardList() {
		return boardList;
	}

	public void setBoardList(List<boardVO> boardList) {
		this.boardList = boardList;
	}

	public int gettPages() {
		return tPages;
	}

	public void settPages(int tPages) {
		this.tPages = tPages;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	@Override
	public String toString() {
		return "boardPageDTO [total=" + total + ", curPage=" + curPage + 
				", boardList=" + boardList + ", tPages=" + tPages + 
				", startPage=" + startPage + ", endPage=" + endPage + "]";
	}
}
