package kr.co.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.command.Command;
import kr.co.command.DeleteCommand;
import kr.co.command.InsertCommand;
import kr.co.command.InsertUICommand;
import kr.co.command.ListPageCommand;
import kr.co.command.ReadCommand;
import kr.co.command.ReplyCommand;
import kr.co.command.ReplyUICommand;
import kr.co.command.UpdateCommand;
import kr.co.command.UpdateUICommand;
import kr.co.domain.CommandAaction;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		String uri = request.getRequestURI();
		String ctxp = request.getContextPath();
		String sp = uri.substring(ctxp.length());
		Command com = null;
		System.out.println(sp);

		if (sp.equalsIgnoreCase("/list.do")) {
			/* com = new ListCommand(); */
			com = new ListPageCommand();
			}else if(sp.equalsIgnoreCase("/insertui.do")){
				com = new InsertUICommand();
			}else if(sp.equalsIgnoreCase("/insert.do")){
				com = new InsertCommand();
				// 6/8일
			}else if(sp.equalsIgnoreCase("/read.do")) {
				com=new ReadCommand();
			}else if(sp.equalsIgnoreCase("/updateui.do")) {
				com= new UpdateUICommand();
			}else if(sp.equalsIgnoreCase("/update.do")) {
				com= new UpdateCommand();
			}else if(sp.equalsIgnoreCase("/delete.do")) {
				com=new DeleteCommand();
			}else if(sp.equalsIgnoreCase("/replyui.do")) {
				com=new ReplyUICommand();
			}else if(sp.equalsIgnoreCase("/reply.do")) {
				com=new ReplyCommand();
			}
			

		if(com!=null)	{
			CommandAaction action=com.execute(request,response);
			
			if(action.isRedirect()) {
				response.sendRedirect(action.getWhere());
				
				
				
			}else {
				request.getRequestDispatcher(action.getWhere()).forward(request,response);
			}
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
