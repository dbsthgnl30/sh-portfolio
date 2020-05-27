package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dao.MemberDAO;
import kr.co.domain.MemberDTO;

public class InsertCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		데이터 받아오기
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String sAge = request.getParameter("age");
		int age = 0;
		if (sAge != null) {
			age = Integer.valueOf(sAge);
		}

//객체 생성 ,해당 메서드 호출 db조작
		MemberDAO dao = new MemberDAO();
		dao.insert(new MemberDTO(id, name, age));
		// 회원목록으로 가기
//			회원가입을 했으니 조회목으로 가는데 주소창이 바뀌는게 낫다 redirect
		response.sendRedirect("select.do");

	}
}
