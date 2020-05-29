package com.naver;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SelectCommand implements Command {

	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		//클라이언트가 보내준 데이터 획득 및 가공
		//DAO객체 생성 및 해당 메서드 호출
		
		MemberDAO dao= new MemberDAO();
		List<MemberDTO> list= dao.selectAll();
		
		//데이터 바인딩 (pageContext, request,session,application)
		request.setAttribute("list", list);
		//포워딩
		return new CommandAction(false, "select.jsp");
		
		
	
	}

}
