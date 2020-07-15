package kr.co.ca;

import kr.co.lg.Sum;
import kr.co.lg.YourThread;

public class MainEx10 {
	//동기화문제해결
	public static void main(String[] args) {
		 Sum sum= new Sum();
		 
		 YourThread y1= new YourThread(0, 5000, sum);
		 YourThread y2= new YourThread(5001,10000, sum);
		 y1.start();
		 y2.start();
		 //y1이끝나기전까지 main쓰레드 종료하지않게하기위해
		 try {
			y1.join();
			y2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println(sum.num1);
	}
}
