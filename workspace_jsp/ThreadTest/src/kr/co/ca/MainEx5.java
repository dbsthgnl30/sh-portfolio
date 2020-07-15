package kr.co.ca;

import com.naver.UserRunnable1;
import com.naver.UserThread1;

public class MainEx5 {
	public static void main(String[] args) {
		System.out.println("main start");
		UserThread1 ut1= new UserThread1();
		ut1.start();
		
		UserRunnable1 ur1= new UserRunnable1();
		Thread urt= new Thread(ur1);
		urt.start();
		
		//main()메서드에서(MainEx5) join()메서드 호출
		try {
			ut1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("main end");
	}
}
