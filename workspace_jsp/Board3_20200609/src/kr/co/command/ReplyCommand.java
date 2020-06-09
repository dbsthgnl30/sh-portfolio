package kr.co.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dao.BoardDAO;
import kr.co.domain.BoardDTO;
import kr.co.domain.CommandAaction;

public class ReplyCommand implements Command {

	@Override
	public CommandAaction execute(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		String snum=request.getParameter("num");
		int orgnum= -1;
		if(snum !=null) {
			orgnum =Integer.parseInt(snum);
		}
			
		String writer=request.getParameter("writer");
		String title=request.getParameter("title");
		String content= request.getParameter("content");
		
		BoardDAO dao= new BoardDAO();
		BoardDTO dto=(new BoardDTO(-1,writer, title, content, null, 0,-1, -1,-1));
		dao.reply(orgnum,dto);
		return new CommandAaction(true, "list.do");
	}

}
