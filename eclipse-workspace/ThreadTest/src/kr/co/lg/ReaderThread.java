package kr.co.lg;

public class ReaderThread  extends Thread{
	Board board;
	public ReaderThread() {
		// TODO Auto-generated constructor stub
	}
	public ReaderThread(Board board) {
		super();
		this.board = board;
	}
	@Override
	public void run() {
		String content =board.getContent();
		System.out.println(content);
	}
	
}
