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
		
		//데이터 받은것을 dao에 넣음 dao는 db와 연결
		dao.insert(new MemberDTO(id, name, age));
		// 회원목록으로 가기
//			회원가입을 했으니 조회목으로 가는데 주소창이 바뀌는게 낫다 redirect
		//frontController로 가는데 그 이유가 
//		insert에서 db로 보낸 데이터를 묶어서 select 로 보내줘야 하니 db에 갔다옴
		response.sendRedirect("select.do");

	}
}
