package kr.co.utils;

import java.io.UnsupportedEncodingException;

public class Utils {
	public static String toKor(String msg) {
		try {
			return new String(msg.getBytes("8859_1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
