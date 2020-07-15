package kr.co.lg;

public class YourThread2 extends Thread {
		public int start;
		public int end;
		public Sum2 sum;
		
		public YourThread2() {
			// TODO Auto-generated constructor stub
		}
		public YourThread2(int start, int end, Sum2 sum) {
			super();
			this.start = start;
			this.end = end;
			this.sum = sum;
		}
		//Thread생성하고있으니 런 추가 ..? 왠지모르게씀
		@Override
		public void run() {
			for (int i = start; i <= end; i++) {
				sum.addNum1(i);
				sum.addNum2(i);
				sum.addNum3(i);
			}
		}
		
}
