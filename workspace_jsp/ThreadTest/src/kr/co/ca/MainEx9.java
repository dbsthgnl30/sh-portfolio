package kr.co.ca;

import kr.co.lg.MyThread;
import kr.co.lg.SyncTest;

public class MainEx9 {
	public static void main(String[] args) {
		
		SyncTest st= new SyncTest();
		System.out.println(st.num);
		
		MyThread t1= new MyThread(st);
		MyThread t2= new MyThread(st);	
		//스레드 만들어 주려고 .start
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(st.num);
	}
	
}
