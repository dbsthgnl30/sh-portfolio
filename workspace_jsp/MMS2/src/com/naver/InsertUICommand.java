package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertUICommand implements Command{

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//회원가입을 입력할 수 있는 창(jsp)
//	아이디, 비번 치는 창으로 이동
		return new CommandAction(false, "insert.jsp");
	}

}
