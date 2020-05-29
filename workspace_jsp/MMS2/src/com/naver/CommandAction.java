package com.naver;

public class CommandAction {
	//포워딩을 어떻게 할껀지
	private boolean isRedirct;
	//포워딩을 어디로 보낼껀지
	private String where;
	
	public CommandAction() {
		// TODO Auto-generated constructor stub
	}
	
	
	public CommandAction(boolean isRedirct, String where) {
		super();
		this.isRedirct = isRedirct;
		this.where = where;
	}


	public boolean isRedirct() {
		return isRedirct;
	}
	public void setRedirct(boolean isRedirct) {
		this.isRedirct = isRedirct;
	}
	public String getWhere() {
		return where;
	}
	public void setWhere(String where) {
		this.where = where;
	}
	
	

}
