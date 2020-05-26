package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dto.MemberDTO;

public class InsertCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		// TODO Auto-generated method stub
	String id=	request.getParameter("id");
	String name=request.getParameter("name");
	String sAge=request.getParameter("age");
	int age=0;
	if(sAge !=null) {
		age=Integer.valueOf(sAge);
	}
	MemberDTO dto= new MemberDTO(id, name, age);
	MemberDAO dao= new MemberDAO();
	dao.insert(dto);
	
//	servlet 으로간다 select 대신 list 라고도 한다
 	response.sendRedirect("select");
	}

}
