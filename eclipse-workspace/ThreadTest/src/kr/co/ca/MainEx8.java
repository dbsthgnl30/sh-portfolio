package kr.co.ca;

public class MainEx8 {
	public static void main(String[] args) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i=0; i<10; i++) {
					System.out.println(i);
				}
				
			}
			
		}).start();//Thread한번쓰고 버릴때 
		
	}
}
