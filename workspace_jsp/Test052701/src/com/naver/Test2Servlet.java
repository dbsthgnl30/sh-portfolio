package com.naver;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test2Servlet
 */
@WebServlet("/test2")
public class Test2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("test2 doGet");
//		object 형이지만 String 으로 형변환
		String url =(String) request.getAttribute("url");
		List<StringBuffer> list =(List<StringBuffer>) request.getAttribute("list");
		System.out.println(url);
		System.out.println(list);
		
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String driverClassName = (String) request.getAttribute("driverClassName");
		System.out.println("dirverClalssName");
		
		
		System.out.println("test2 doPost");
//		doGet(request, response);
	}

}
