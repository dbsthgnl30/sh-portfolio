package com.naver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test3
 */
@WebServlet("/test3")
public class Test3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//서블릿 컨테스트 객체 가져옴
		ServletContext application =getServletContext();
		application.setAttribute("hello", "hello");
		
		//어플ㄹ리케이션엔 방문자수만 저장
		List<StringBuffer> list= new ArrayList<StringBuffer>();
		list.add(new StringBuffer("good"));
		list.add(new StringBuffer("morning"));
		application.setAttribute("list", list);
		
		Integer icount =(Integer) application.getAttribute("count");
		if(icount==null) {
			icount = 1;
			application.setAttribute("count", icount);
		}else {
			application.setAttribute("count", icount+1);
		
		}
//		forward하는것
		request.getRequestDispatcher("NewFile.jsp").forward(request, response);
//requestDispatcher dis= request.getRequestDispatcher("NewFile.jsp");	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
