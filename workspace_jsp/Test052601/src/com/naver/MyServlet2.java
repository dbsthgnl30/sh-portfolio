package com.naver;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet2
 */
@WebServlet("/ms4")
public class MyServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		//서버로 들어오는 문자는 모두 다 String
//		String id =request.getParameter("id");
////		id="tt";
//		String pw=request.getParameter("pw");
////		pw="123";
//		String sAge=request.getParameter("age");
//		int age=Integer.parseInt(sAge); 
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String name =request.getParameter("name");
		String sAge=request.getParameter("age");
		int age=0;
		if (sAge!=null) {
			 age = Integer.parseInt(sAge);
		}
		PrintWriter out=response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print(name);
		out.print(sAge);
		out.print("<body>");
		out.print("<html>");
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
	response.setContentType("text/html;charset=utf-8");
	String ID =	request.getParameter("id");	
	System.out.println("id");
	String PW =	request.getParameter("pw");
	PrintWriter out = response.getWriter();
	out.print("<html>");
	out.print("<body>");
	out.print(ID);
	out.print(PW);
	out.print("</body>");
	out.print("</html>");
	
				
		
	}

}
