package kr.co.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dao.BoardDAO;
import kr.co.domain.BoardDTO;
import kr.co.domain.CommandAaction;

public class UpdateUICommand implements Command {

	@Override
	public CommandAaction execute(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		String sNum=request.getParameter("num");
		int num=-1;
		if(sNum!=null) {
			num=Integer.parseInt(sNum);
		}
		BoardDAO dao=new  BoardDAO();
		BoardDTO dto=dao.updateUI(num);
		System.out.println(num);
		request.setAttribute("dto", dto);
		return new CommandAaction(false, "update.jsp");
	}

}
