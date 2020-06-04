package com.naver;

public class MainEx {
	public static void main(String[] args) {
		
		Test t3= new Test();
		t3.me4();
		System.out.println("::::::::::::::::::::::::::::::::::::");
		
		
		Test t2= new Test();
		t2.me3();
		System.out.println("::::::::::::::::::::::::::::::::::::");
		
		Test t1= new Test();
		long start = System.currentTimeMillis();
		t1.me1();
		long end= System.currentTimeMillis();
		System.out.println(end-start);
		
		System.out.println("::::::::::::::::::::::::::::::::::::::::::");
		start = System.currentTimeMillis();
		t1.me2();
		 end= System.currentTimeMillis();
		System.out.println(end-start);
		
		
		
		
		
		
		
	}
}
