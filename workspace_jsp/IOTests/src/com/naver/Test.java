package com.naver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Test {
	public void me2() {
		File f1 = new File("C:" + File.separator + "test.jpg");
		File f2 = new File("C:", "copytest.jpg");
		
		InputStream in= null;
		OutputStream out= null;
		byte[] arr= new byte[512];
		
		
		try {
			in =new FileInputStream(f1);
			out=new FileOutputStream(f2);
			
			while(true) {
				int leng=in.read(arr);//leng 읽어온갯수를 반환
				if(leng==-1) {
					break;
				}
				out.write(arr, 0, leng);
			}
			System.out.println("파일 복사 완료");
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}finally {
			try {
				if(in !=null) {
					in.close();
				}
				if(out !=null) {
					out.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();// TODO: handle exception
			}
		}
		
		
		
		
		
	}
	
	
	
	
	
	public void me1() {
		File f1 = new File("C:" + File.separator + "test.jpg");
		File f2 = new File("C:", "copytest.jpg");

		InputStream in = null;
		OutputStream out = null;
		int what = -1;
		try {
			in = new FileInputStream(f1);
			out= new FileOutputStream(f2);
			
			while(true) {
			what = in.read();
				if(what==-1) {
					break;
				}
				out.write(what);
			}
			System.out.println("파일 복사 종료");
			
			
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (out != null) {
					out.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}