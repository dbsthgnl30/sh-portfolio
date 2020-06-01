package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.naver.MemberDAO;
import com.naver.LoginDTO;

public class DeleteCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//세션 통해서 로그인  되있는지 확인 
		HttpSession session = request.getSession(false);
		if (session != null) {
			LoginDTO loginDTO = (LoginDTO) session.getAttribute("login");
			if (loginDTO != null) {
				String id= request.getParameter("id");
				//같은 아이디인지
				if (loginDTO.getId().equals(id)) {
					MemberDAO dao = new MemberDAO();
					dao.delete(id);
					//로그아웃 시킴
					session.invalidate();
					return new CommandAction(true, "select.bo");
					
										
					// 다시 회원목록으로 돌아가눈 코드
					
				} else {
					return new CommandAction(true, "loginui.bo");
				}
				
			} else {
				return new CommandAction(true, "loginui.bo");
			}

		} else {
			return new CommandAction(true, "loginui.bo");
		}

	}

}
