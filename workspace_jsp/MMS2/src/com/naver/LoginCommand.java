package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.dao.MemberDAO;
import kr.co.domain.LoginDTO;
import kr.co.domain.MemberDTO;

public class LoginCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id=request.getParameter("id");
		String pw= request.getParameter("pw");

		MemberDAO dao =new MemberDAO();//db접근
		boolean login=  dao.login(new LoginDTO(id, pw));////?????????????????????
		
		
		
		
		if(login) {
			HttpSession session =request.getSession();
			session.setMaxInactiveInterval(60);
			session.setAttribute("login", new LoginDTO(id, null));
			response.sendRedirect("select.do");
		}else {
//			로그인 실패시
			response.sendRedirect("loginui.do");
		}

		
	}

}
