package kr.co.domain;

public class CommandAaction {
	private boolean isRedirect;
	private String where;
	
	public CommandAaction() {
		// TODO Auto-generated constructor stub
	}

	public CommandAaction(boolean isRedirect, String where) {
		super();
		this.isRedirect = isRedirect;
		this.where = where;
	}

	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}

	public String getWhere() {
		return where;
	}

	public void setWhere(String where) {
		this.where = where;
	}
	
}
