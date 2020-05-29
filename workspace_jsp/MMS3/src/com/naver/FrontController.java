package com.naver;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.smartcardio.CommandAPDU;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.bo")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글 구현 꼭하기 
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//클라이언트가 보내준거 받음request
		String uri= request.getRequestURI();
		String ctxp=request.getContextPath();
		String sp=uri.substring(ctxp.length()) ;
		Command com= null;
		System.out.println(sp);
		//처음에 command랑 commandAction 만들기 그리고 selectcommand 만들기
		if(sp.equalsIgnoreCase("/select.bo")){
			com = new SelectCommand();
		}else if(sp.equalsIgnoreCase("/insertui.bo")) {
			com= new InsertUICommand();
		}else if(sp.equalsIgnoreCase("/insert.bo")) {
			com= new InsertCommand();
		}else if(sp.equalsIgnoreCase("/selectById.bo")) {
			com= new SelectByIdCommand();
		}else if(sp.equalsIgnoreCase("/updateui.bo")) {
			com = new UpdateUICommand();
		}else if(sp.equalsIgnoreCase("/update.bo")) {
			com= new UpdateCommand();
		}else if(sp.equalsIgnoreCase("/loginui.bo")) {
			com= new LoginuiCommand();
			
		}else if(sp.equalsIgnoreCase("/login.bo")) {
			com= new LoginCommand();
		}
		
		
		
		else {
			System.out.println("제공하지 않는 서비스입니다.");
		}
		
		
		
		
		
		
		
		if(com!=null)	{
			CommandAction action=com.execute(request,response);
			
			if(action.isRedirect()) {
				response.sendRedirect(action.getWhere());
			}else {
				request.getRequestDispatcher(action.getWhere()).forward(request,response);
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
