package kr.co.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dao.BoardDAO;
import kr.co.domain.BoardDTO;
import kr.co.domain.CommandAaction;

public class ReadCommand implements Command {

	@Override
	public CommandAaction execute(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		//num을 받아오는데 String->int
	String snum=request.getParameter("num");
	int num= -1;
	if(snum !=null) {
		num =Integer.parseInt(snum);
	}
		BoardDAO dao= new BoardDAO();
		//reae=select 3번째 num을 dao에read메소트를 통해 받아와ㅏ서 dto(급식판)에 넣어줘
		BoardDTO dto= dao.read(num);
		//데이터 바인딩 (묶는작업)
		request.setAttribute("dto", dto);
		//url이 바뀌지않아
		return new CommandAaction(false, "read.jsp");
	}

}
