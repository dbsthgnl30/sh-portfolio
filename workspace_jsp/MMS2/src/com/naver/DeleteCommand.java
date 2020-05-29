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
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		HttpSession session = request.getSession(false);
		if (session != null) {
			LoginDTO loginDTO = (LoginDTO) session.getAttribute("login");
			if (loginDTO != null) {
				if (loginDTO.getId().equals(id)) {
					MemberDAO dao = new MemberDAO();
					dao.delete(id);
					//로그아웃 시킴
					session.invalidate();
					return new CommandAction(true, "select.do");
					
										
					// 다시 회원목록으로 돌아가눈 코드
					
				} else {
					return new CommandAction(true, "loginui.do");
				}
				
			} else {
				return new CommandAction(true, "loginui.do");
			}

		} else {
			return new CommandAction(true, "loginui.do");
		}

	}
}
