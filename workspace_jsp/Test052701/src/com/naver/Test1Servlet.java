package com.naver;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test1Servlet
 */
@WebServlet("/test1")
public class Test1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("url", "http://www.naver.com");
		request.setAttribute("list", new ArrayList<StringBuffer>());
		
		
		System.out.println("test1 doGet");
		RequestDispatcher dis= request.getRequestDispatcher("test2");
		dis.forward(request, response);
		
//		request.getRequestDispatcher("test2").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String driverClassname="oracle.jdbc.driver.OracleDriver";
		request.setAttribute("driverClassName", driverClassname);
		
		
		
		System.out.println("test1 doPost");
//		request.getRequestDispatcher("test2").forward(request, response);
		
	}

}
