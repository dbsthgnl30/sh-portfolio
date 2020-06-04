package com.google;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;

public class Test {
	public void me4() {
		File f1=new File("C:" +File.separator+"no.txt");
		InputStream in =null;
		InputStreamReader isr =null;
		BufferedReader br= null;
		try {
			in= new FileInputStream(f1);
			isr=new InputStreamReader(in);
			br= new BufferedReader(isr);
			
			while(true) {
				String msg = br.readLine();
				if(msg==null)break;
				System.out.println(msg);
			}
			
			
			
		} catch (Exception e) {
		e.printStackTrace();	// TODO: handle exception
		}finally {
			try {
				if(br!=null) {
					br.close();
				}
				if(isr !=null) {
					isr.close();
				}
				if(in!=null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();// TODO: handle exception
			}
		}
		f1.renameTo(new File("C:","nono.txt"));
	}
	public void me3() {
		Writer out =null;
		BufferedWriter bw=null;
		Reader in= null;
		BufferedReader br=null;
		 try {
			 	out= new FileWriter("C:"+File.separator+"no.txt");
			 	bw=new BufferedWriter(out);
			 	
			 	bw.write("hello");
			 	bw.write(System.getProperty("line.separator"));
			 	bw.write("world");
			 	bw.write(System.getProperty("line.separator"));
			 	bw.write("good");
			 	bw.write(System.getProperty("line.separator"));
			 	//스트링의 찌꺼기를 비워준다
			 	bw.flush();
			 	
			 	
			 	
			 	in = new FileReader("C:"+File.separator+"no.txt");
			 	br= new BufferedReader(in);
			 	while(true){
			 		String msg= br.readLine();
			 		if(msg==null) {
			 			break;
			 		}
			 		System.out.println(msg);
			 	}
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}finally {
			try {
				if(bw!=null) {
					bw.close();
				}
				if(out !=null) {
					out.close();
				}
				if(br!=null) {
					br.close();
				}
				if(in!=null) {
					in.close();
				}
				
			} catch (Exception e2) {
			e2.printStackTrace();	// TODO: handle exception
			}
		}
	}
	public void me2() {
		File f1= new File("C:","test112.txt.txt");
		File  f2= new File("C:","copytest113.txt.txt");
		
		Reader in= null;
		BufferedReader br= null;
		
		Writer out= null;
		BufferedWriter bw= null;
		try {
			in =new FileReader(f1);
			br=new BufferedReader(in);
			
			out= new FileWriter(f2);
			bw= new BufferedWriter(out);
			String msg="";
			while(true) {
				msg=br.readLine();
				
				if(msg==null) {
					break;
				}
				bw. write(msg);
				bw.write(System.getProperty("line.separator"));
			}
			System.out.println("파일 복사 완료");
		
		} catch (Exception e) {
		e.printStackTrace();	// TODO: handle exception
		}finally {
			try {
				if(br!=null) {
					br.close();
				}
				if(in!=null) {
					in.close();
				}
				if(bw!=null) {
					bw.close();
				}
				if(out!=null) {
					out.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public void me1() {
		File f1= new File ("C:"+File.separator+"test112.txt.txt");
		File f2= new File ("C:"+File.separator+"copytest112.txt.txt");
		
		Reader in = null;
		Writer out =null;
		
		try {
			in = new FileReader(f1);
			out= new FileWriter(f2);
			
		
				char[] arr= new char[64];
				int leng=-1;
				
				while(true) {
				leng = in.read(arr, 0, arr.length);
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
				if(in!=null) {
					in.close();
				}
				if(out!=null) {
					out.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();// TODO: handle exception
			}
		}
	}
}
