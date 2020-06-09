package kr.co.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dao.BoardDAO;
import kr.co.domain.BoardDTO;
import kr.co.domain.CommandAaction;

public class InsertCommand implements Command {

	@Override
	public CommandAaction execute(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		String writer= request.getParameter("writer");
		String title=request.getParameter("title");
		String content= request.getParameter("content");
		
		
		
		
		BoardDAO dao=new BoardDAO();
		dao.insert(new BoardDTO(-1, writer, title, content, null, 0, 0, 0, 0));
		
		
//			for (int i = 0; i < 100; i++) {
//				dao.insert(new BoardDTO(-1, "writer" + 1, "title" + 1, "content" + 1, null, 0, 0, 0, 0));
//				try {
//					Thread.sleep(50);
//				} catch (InterruptedException e) {
//					
//					e.printStackTrace();
//				}
//			}
		return new CommandAaction(true, "list.do");
	}

}
