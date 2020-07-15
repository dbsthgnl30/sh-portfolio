package kr.co.ca;

import com.naver.UserThread1;

public class MainEx2 {
	public static void main(String[] args) {
		System.out.println("main start");
		//스레드 객체 만들어짐  스레드와 스레드 객체는 다름
		UserThread1 ut1 = new UserThread1();//ut1이 stack new UserThread1이 heap
		ut1.start();//사용자 스레드 하나더 만들어짐
		System.out.println("main end");
		
		
	}
}
