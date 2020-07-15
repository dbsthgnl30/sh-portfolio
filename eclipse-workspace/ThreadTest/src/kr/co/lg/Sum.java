package kr.co.lg;

public class Sum {
	public int num1;
	
	//동기화문제를 해결해보자(synchronized추가)
	
	public synchronized void addNum1(int n) {
		num1=num1+n;
	
	}
	
}
