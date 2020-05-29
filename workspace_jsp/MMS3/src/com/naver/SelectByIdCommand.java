package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SelectByIdCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id= request.getParameter("id");
		MemberDAO dao= new MemberDAO();
		MemberDTO dto= dao.selectById(id);
		System.out.println(dto);
		request.setAttribute("dto", dto);
		return new CommandAction(false, "selectById.jsp");
	}

}
