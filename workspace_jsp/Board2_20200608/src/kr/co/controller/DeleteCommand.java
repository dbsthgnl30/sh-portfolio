package kr.co.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.command.Command;
import kr.co.dao.BoardDAO;
import kr.co.domain.CommandAaction;

public class DeleteCommand implements Command {

	@Override
	public CommandAaction execute(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		
		String sNum=request.getParameter("num");
		int num=-1;
		if(sNum !=null) {
			num=Integer.parseInt(sNum);
		}
		BoardDAO dao= new BoardDAO();
		dao.delete(num);
		return new CommandAaction(true, "list.do");
	}

}
