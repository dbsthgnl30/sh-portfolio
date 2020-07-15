package kr.co.ca;

import com.naver.UserRunnable1;

public class MainEx3 {
	public static void main(String[] args) {
		System.out.println("main start");
		UserRunnable1 ur1 = new UserRunnable1();
		//스레드 객체 만들어짐 스레드 안만들어짐
		Thread urt1= new Thread(ur1);
		//스레드 만들려면 스레드 스타트 객체 만들어야됨
		urt1.start();
		System.out.println("main end");
	}
}
