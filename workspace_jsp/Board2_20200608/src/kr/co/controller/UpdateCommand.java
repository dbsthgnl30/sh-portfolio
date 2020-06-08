package kr.co.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.command.Command;
import kr.co.dao.BoardDAO;
import kr.co.domain.BoardDTO;
import kr.co.domain.CommandAaction;

public class UpdateCommand implements Command {

	@Override
	public CommandAaction execute(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		String sNum=request.getParameter("num");
		int num =-1;
		if(sNum!=null) {
			num=Integer.parseInt(sNum);
		}
		String writer=request.getParameter("writer");
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		
		
		BoardDAO dao= new BoardDAO();
		dao.update(new BoardDTO(num, writer, title, content, null, -1, -1, -1, -1));
		return new CommandAaction(true, "list.do");
	}

}
