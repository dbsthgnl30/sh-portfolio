package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id= request.getParameter("id");
		String pw= request.getParameter("pw");
		String name = request.getParameter("name");
		String sAge= request.getParameter("age");
		int age=0;
		if(sAge!=null) {
			age=Integer.valueOf(sAge);
		}
		MemberDAO dao= new MemberDAO();
		
		dao.insert(new MemberDTO(id, pw, name, age));
		return new CommandAction(true, "select.bo");
	}

}
