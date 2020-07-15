package kr.co.ca;

import kr.co.lg.Board;
import kr.co.lg.ReaderThread;
import kr.co.lg.WriterThread;

public class MainEx12 {
	public static void main(String[] args) {
		Board board= new Board();
		
		WriterThread wt= new WriterThread(board);
		ReaderThread rt= new ReaderThread(board);
		
		wt.start();
		rt.start();
		
	}
}
