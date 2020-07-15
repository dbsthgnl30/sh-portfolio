package kr.co.lg;

public class WriterThread extends Thread {
Board board;
public WriterThread() {
	// TODO Auto-generated constructor stub
}
public WriterThread(Board board) {
	super();
	this.board = board;
}
@Override
public void run() {
	board.setContent("hello");
}

}
