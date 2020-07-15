package kr.co.ca;

public class MainEx {
	public static void main(String[] args) {
		Thread ct=Thread.currentThread();
		String ctname=ct.getName();
		System.out.println(ctname);
		
	}
}
