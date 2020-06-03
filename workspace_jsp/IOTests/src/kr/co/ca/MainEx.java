package kr.co.ca;

import java.io.File;

public class MainEx {

	public static void main(String[] args) {
		File f4= new File("C:"+File.separator+"BBB");
		if(!f4.exists()) {
			f4.mkdir();
		}
		File f5= new File("C:", "new.txt");
		File f6= new File(f4, "new.txt");
		f5.renameTo(f6);
		
		
		File f3= new File("C:", "test119.txt");
		File newName= new File ("C:","new.txt");
		
		f3.renameTo(newName);
		
		
		
		
	File f2= new File("C:"+File.separator+"text119.txt");
		
		boolean isDel = f2.delete();
		 if(isDel) {
			 System.out.println("삭제성공");
		 }else
			 System.out.println("삭제실패");
		
		
		
		
		
		
		
		
		
		File f1= new File("C:"+File.separator+"AAA");
		if(!f1.exists()) {
			//폴더생성
			f1.mkdir();
			System.out.println("AAA폴더가 없습니다.");
		}else {
			//폴더삭제
			f1.delete();
			System.out.println("AAA폴더가 있습니다.");
		}
	}

}
