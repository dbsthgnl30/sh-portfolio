package kr.co.domain;

import java.util.List;

public class PageTO {
	//각각의 변수가무엇을 의미하는지
	private int curPage = 1;// 몇번부터 몇번까지? 기준은 현재페이지
	private int perPage = 10;// 한페이지에 나오는 num수
	private int pageLine = 10;// 1페이지에 넣을 수 있는 페이지번호 수
	private int amount;// 게시글의 총개수

	private int totalPage;// 총 몇페이지가 필요한지//amount,curPage종속

	private int startNum;// norum 값 1번부터//curPage종속
	private int endNum;// norum 10번까지

	private int beginPageNum;/// 1페이지부터// curPage종속
	private int stopPageNum;// 10페이지까지

	private List<BoardDTO> list;//

	public PageTO() {
		changeVarVal();
	}

	public PageTO(int curPage) {
		super();
		this.curPage = curPage;
		changeVarVal();
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
		changeVarVal();
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
		changeVarVal();
	}

	public int getPageLine() {
		return pageLine;
	}

	public void setPageLine(int pageLine) {
		this.pageLine = pageLine;
		changeVarVal();
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
		changeVarVal();
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getStartnum() {
		return startNum;
	}

	public void setStartnum(int startnum) {
		this.startNum = startnum;
	}

	public int getEndnum() {
		return endNum;
	}

	public void setEndnum(int endnum) {
		this.endNum = endnum;
	}

	public int getBeginPageNum() {
		return beginPageNum;
	}

	public void setBeginPageNum(int beginPageNum) {
		this.beginPageNum = beginPageNum;
	}

	public int getStopPageNum() {
		return stopPageNum;
	}

	public void setStopPageNum(int stopPageNum) {
		this.stopPageNum = stopPageNum;
	}

	public List<BoardDTO> getList() {
		return list;
	}

	public void setList(List<BoardDTO> list) {
		this.list = list;
	}

	private void changeVarVal() {
		totalPage = amount / perPage;
		if (amount % perPage != 0) {
			totalPage = totalPage + 1;
		}

		startNum = (curPage - 1) * perPage + 1;
		
		endNum=curPage*perPage;
		if(endNum>amount) {
			endNum=amount;
			//총게시글의  수가 27 endNum=30
		}
		beginPageNum=((curPage-1)/pageLine)*pageLine+1;
		
		stopPageNum=beginPageNum+(pageLine-1);
		if(stopPageNum>totalPage) {
			stopPageNum=totalPage;
		}	
		
	}

}
