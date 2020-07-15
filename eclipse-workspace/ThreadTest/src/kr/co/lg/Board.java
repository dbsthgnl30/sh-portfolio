package kr.co.lg;

public class Board {
	private String content;
	boolean isOk=false;
	//데이터를 가져와서 읽음
	public String getContent() {
	if(!isOk) {
		try {
			synchronized (this) {
				wait();
			}
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
		
		return content;
	}

	public void setContent(String content) {
		this.content = content;
		isOk=true;
		synchronized (this) {
			notifyAll();
		}
	}
	
	
}
