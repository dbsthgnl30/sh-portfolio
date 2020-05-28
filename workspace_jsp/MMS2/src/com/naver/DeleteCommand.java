package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.dao.MemberDAO;
import kr.co.domain.LoginDTO;
import kr.co.domain.MemberDTO;

public class DeleteCommand implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		HttpSession session = request.getSession(false);
		if (session != null) {
			LoginDTO loginDTO = (LoginDTO) session.getAttribute("login");
			if (loginDTO != null) {
				if (loginDTO.getId().equals(id)) {
					MemberDAO dao = new MemberDAO();
					dao.delete(id);
					// 다시 회원목록으로 돌아가눈 코드
					response.sendRedirect("select.do");
				} else {
					response.sendRedirect("loginui.do");
				}
				
			} else {
				response.sendRedirect("loginui.do");
			}
//			이 괄호는 왜있찌?
		} else {
			response.sendRedirect("loginui.do");
		}

	}
}
