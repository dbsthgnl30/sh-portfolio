package com.naver;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test5Servlet
 */
@WebServlet("*.do")
public class Test5Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test5Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		한글지원코드
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String uri= request.getRequestURI();
		String ctxp= request.getContextPath();
		String sp= uri.substring(ctxp.length());
		System.out.println(uri);
		System.out.println(ctxp);
//		String sp= request.getServletPath();
//		System.out.println(sp);
		
		if(sp.equalsIgnoreCase("insert.do")) {
			System.out.println("입력입니다.");
		}else if(sp.equalsIgnoreCase("select.do")) {
			System.out.println("조회입니다.");
		}else if(sp.equalsIgnoreCase("/update.do")) {
			System.out.println("수정입니다.");
		}
		
//		System.out.println(".do로 끝나는 요청은 모두 이 서블릿으로 들어온다.");
		
		//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
