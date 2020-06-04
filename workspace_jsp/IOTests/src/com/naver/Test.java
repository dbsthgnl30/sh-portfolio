package com.naver;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Test {
	public void me4() {
		File f1 = new File("C:" + File.separator + "test112.txt.txt");
		File f2 = new File("C:", "copytest112");

		InputStream in = null;
		BufferedInputStream bis = null;

		OutputStream out = null;
		BufferedOutputStream bos = null;

		try {
			in = new FileInputStream(f1);
			bis = new BufferedInputStream(in);
			out = new FileOutputStream(f2);
			bos = new BufferedOutputStream(out);

			int what = -1;

			while (true) {
				what = bis.read();
				if (what == -1) {
					break;
				}
				bos.write(what);
			}
			System.out.println("파일 복사 종료");

		} catch (Exception e) {
			e.printStackTrace(); // TODO: handle exception
		} finally {
			try {
				if (bos != null) {
					bos.close();
				}
				if (out != null) {
					out.close();

				}
				if (bis != null) {
					bis.close();
				}
				if (in != null) {
					in.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace(); // TODO: handle exception
			}
		}
	}

//buffered in.outputStream
	public void me3() {
		File f1 = new File("C:" + File.separator + "show.jpg");
		File f2 = new File("C:", "copyshow.jpg");
		InputStream in = null;
		BufferedInputStream bis = null;

		OutputStream out = null;
		BufferedOutputStream bos = null;

		try {
			in = new FileInputStream(f1);
			bis = new BufferedInputStream(in);
			out = new FileOutputStream(f2);
			bos = new BufferedOutputStream(out);

			int what = -1;

			while (true) {
				what = bis.read();
				if (what == -1) {
					break;
				}
				bos.write(what);
			}
			System.out.println("파일 복사 종료");

		} catch (Exception e) {
			e.printStackTrace(); // TODO: handle exception
		} finally {
			try {
				if (bos != null) {
					bos.close();
				}
				if (out != null) {
					out.close();

				}
				if (bis != null) {
					bis.close();
				}
				if (in != null) {
					in.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace(); // TODO: handle exception
			}
		}
	}

	public void me2() {
		File f1 = new File("C:" + File.separator + "test.jpg");
		File f2 = new File("C:", "copytest.jpg");

		InputStream in = null;
		OutputStream out = null;
		byte[] arr = new byte[512];

		try {
			// 연결통로
			in = new FileInputStream(f1);
			out = new FileOutputStream(f2);

			while (true) {
				int leng = in.read(arr);// leng 읽어온갯수를 반환
				if (leng == -1) {
					break;
				}
				out.write(arr, 0, leng);
			}
			System.out.println("파일 복사 완료");
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
			out = new FileOutputStream(f2);

			while (true) {
				what = in.read();
				if (what == -1) {
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