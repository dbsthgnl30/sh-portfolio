package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id= request.getParameter("id");
		String name= request.getParameter("name");
		String pw= request.getParameter("pw");
		String sAge= request.getParameter("age");
		
		int age=0;
		if(sAge!=null) {
			age=Integer.parseInt(sAge);
			
		}
		new MemberDAO().update(new MemberDTO(id, pw, name, age));
	
		
		return new CommandAction(true, "selectById.bo?id="+id);
			
		
	}

}
