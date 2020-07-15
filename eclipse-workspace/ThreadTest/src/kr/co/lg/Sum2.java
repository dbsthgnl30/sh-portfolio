package kr.co.lg;

public class Sum2 {
	public int num1;
	public int num2;
	public int num3;
	Object key1= new Object();
	
	Object key2= new Object();
	
	//동기화문제를 해결해보자(synchronized추가)
	public void subNum1(int n) {
		synchronized (this) {
			num1 = num1 - n;
		}
	}
	//addNum2와  같은 num2이므로 같은 key1
	public void subNum2(int n) {
		synchronized (key1) {
			num2 = num2 - n;
		}
	}
	public  void addNum1(int n) {
		synchronized (this) {
			num1 = num1 + n;
		}
	
	}
	public void addNum2(int n) {
		synchronized (key1) {
			num2 = num2 + n;
		}
	}
	public void addNum3(int n) {
		synchronized (key2) {
			num3 = num3 + n;
		}
	}
}
