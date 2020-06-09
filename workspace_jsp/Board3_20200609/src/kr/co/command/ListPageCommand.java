package kr.co.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dao.BoardDAO;
import kr.co.domain.CommandAaction;
import kr.co.domain.PageTO;

public class ListPageCommand implements Command {

	@Override
	public CommandAaction execute(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
	String scurPage= request.getParameter("curPage");
	int curPage=1;//1page나오게 하고싶다면 1넣기//-1을 넣는 이유는 값이 들어갔나 확인ㄴ하기 위해서. 아무것도 안들어갔으면 -1나온다
	if (scurPage!=null) {//list.do로 접속 했을때
		curPage= Integer.parseInt(scurPage);
	}
	
	BoardDAO dao= new BoardDAO();
	PageTO to = dao.page(curPage);//페이지 마다 뭐가 나오는지.게시글이 몇개인지 알아야 페이징 처리 가능. begin end도 알아야댐
	request.setAttribute("to", to);
	request.setAttribute("list", to.getList());
	//<c:forEach items="${list}" var="dto">**${list}사용하기위해서

	return new CommandAaction(false, "list.jsp");
	}

}
