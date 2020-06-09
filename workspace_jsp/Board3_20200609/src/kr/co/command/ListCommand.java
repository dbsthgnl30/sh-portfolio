package kr.co.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dao.BoardDAO;
import kr.co.domain.BoardDTO;
import kr.co.domain.CommandAaction;

public class ListCommand implements Command {

	@Override
	public CommandAaction execute(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		BoardDAO dao= new BoardDAO();
		List<BoardDTO> list= dao.list();
		request.setAttribute("list", list);
		return new CommandAaction(false, "list.jsp");
	}

}
