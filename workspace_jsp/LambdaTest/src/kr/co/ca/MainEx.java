package kr.co.ca;

import com.naver.Cat;
import com.naver.CatImpl;
import com.naver.Dog;
import com.naver.Turtle;
import com.naver.TurtleImpl;

public class MainEx {
	public static void main(String[] args) {
		//람다
		Turtle t= (String a, int b)->{
			for(int i=0; i<b; i++) {
				System.out.println(a);
			}
		};
		t.me3("hello world", 5);
		
		Turtle t2=new TurtleImpl();
		t2.me3("good", 10);
		
		
		
		
		Turtle t1=new Turtle() {
			
			@Override
			public void me3(String str, int c) {
				System.out.println(str+c);
				
			}
		};
		
		t1.me3("hello",3);
		//cat이 가지고 있는 me2()
		Cat c= (int a)->{
			System.out.println("Cat lambda :"+a);
		};
		c.me2(10);
		
		System.out.println("::::::::::::::::::::::::::::::");
		
		
		Cat c2= new CatImpl();
		c2.me2(5);
		
		Cat c1 = new Cat() {
			
			@Override
			public void me2(int a) {
				System.out.println("CatImpl");
				
			}
		};
		c1.me2(10);
		
		
		System.out.println("::::::::::::::::::::::::::::::");
		
		
		//dog라고 하는 인터페이스를 오버라이딩 하겠다
		Dog d =  () -> {
			System.out.println("Dog인터페이스의 me1()메서드 오버라이딩");
		};
		
		d.me1();
		
		
		
		
		System.out.println("::::::::::::::::::::::::::::::");
		
		
		// dog클래스를 구현하는 클래스
		class DogImpl implements Dog {

			@Override
			public void me1() {
				System.out.println("DogImpl");
				
				
			}

		}
		
		Dog d2= new DogImpl();
		d2.me1();
		
		
		//인터페이스로객체 만들기
		Dog d1 = new Dog() {

			@Override
			public void me1() {
				System.out.println("d1");

			}
		};
		d1.me1();

	}
}
