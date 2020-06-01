package com.naver;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class MyFilter
 */
//@WebFilter("/*")
public class MyFilter implements Filter {

    /**
     * Default constructor. 
     */
    public MyFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request,
			ServletResponse response, 
			FilterChain chain) throws IOException, ServletException {
	//request때 실행되는 코드
		System.out.println("MyFilter request");
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("test/html;charset=UTF-8");
		chain.doFilter(request, response);
	//response때 실행되는 코드
		System.out.println("MyFilter response");
		
	}
	

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
