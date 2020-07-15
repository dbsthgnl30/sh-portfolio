package com.naver;

public class UserThread1 extends Thread{

	@Override
	public void run() {
		//ut1의사용자메소드에 실행할 코드
		for(int i=0; i<10; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);//1초
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		
	}

}
