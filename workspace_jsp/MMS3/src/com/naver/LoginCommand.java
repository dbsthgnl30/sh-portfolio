package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id= request.getParameter("id");
		String pw=request.getParameter("pw");
		
		boolean isLogin =new MemberDAO().login(new LoginDTO(id,pw));
		if(isLogin) {
			HttpSession session= request.getSession();
			session.setAttribute("login", new LoginDTO(id,null));
			return new CommandAction(true, "select.bo");
		}else {
			return new CommandAction(true,"loginui.bo");
		}
		
	}

}
