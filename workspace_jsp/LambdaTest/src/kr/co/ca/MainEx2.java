package kr.co.ca;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class MainEx2 {
	public static void main(String[] args) {
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(5);
		set.add(500);
		set.add(3);
		set.add(11);
		System.out.println("*******************************");
		
		set.forEach(x->{
			System.out.println(x);
			
		});
		System.out.println(":::::::::::::::::::::::::::::::::");
		Iterator<Integer> it = set.iterator();
		
		while (it.hasNext()) {
			Integer integer = it.next();
			System.out.println(integer);
			
		}
	}
}
