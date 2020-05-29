package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dao.MemberDAO;
import kr.co.domain.MemberDTO;

public class UpdateUICommand implements Command{
	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1.클라이언트가 보내준데이터 획득/가공 / 클ㄹ라이언트가 보내는 서버는 무조건  String 으로 받는다
//		아이디가 주키 이기 때문에 id를 불러와서 수정
		String id= request.getParameter("id");
		
//		2.DAO 객체 만들고 해당 메서드 호출
		MemberDAO dao =new MemberDAO();
		MemberDTO dto= dao.updateUI(id);////?????????????????????
		
		
		
//		3.데이터 바인딩(pageContext, request(동일 request에대해서 데이터가 유효하다),session(로그인), application(방문자수))
		request.setAttribute("dto",dto);
//		4.포워딩(disapatcher(request),redirect(response))
		return new CommandAction(false, "update.jsp");
		
	}
}
