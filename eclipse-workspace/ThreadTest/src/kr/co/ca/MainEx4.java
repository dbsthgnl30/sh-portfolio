package kr.co.ca;

import com.naver.UserRunnable1;
import com.naver.UserThread1;

public class MainEx4 {
	public static void main(String[] args) {
		//메인스레드영역
		System.out.println("main start");
		UserThread1 ut1= new UserThread1();
		ut1.start();
		
		UserRunnable1 ur1= new UserRunnable1();
		Thread urt = new Thread(ur1);
		urt.start();
		
		
		System.out.println("main end");
	}
}
