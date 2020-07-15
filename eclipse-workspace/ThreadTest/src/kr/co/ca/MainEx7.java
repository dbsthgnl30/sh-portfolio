package kr.co.ca;

import com.naver.UserRunnable1;
import com.naver.UserThread1;

public class MainEx7 {
	public static void main(String[] args) {
		//my스레드가 항상 you스레드보다 작업 일찍 끝나게
		System.out.println("main start");
		 UserThread1 my= new UserThread1();
		 my.start();
		 
		 UserRunnable1 ur1= new UserRunnable1(my);
		 Thread you= new Thread(ur1);
		 you.start();
		 
		 
		 System.out.println("main end");
	}
}
