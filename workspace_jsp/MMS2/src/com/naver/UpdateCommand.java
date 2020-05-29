package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dao.MemberDAO;
import kr.co.domain.MemberDTO;

public class UpdateCommand implements Command {
@Override
public CommandAction execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
//	1.클라이언트가 보내준데이터 획득/가공 / 클ㄹ라이언트가 보내느 서버는 무조건  String 으로 받는다
	String id=request.getParameter("id");
	String name=request.getParameter("name");
	String sAge= request.getParameter("age");
	int age=0;
	if(sAge !=null) {
		age=Integer.parseInt(sAge);
	}
//	2.DAO 객체 만들고 해당 메서드 호출
	
	MemberDAO dao= new MemberDAO();
	dao.update(new MemberDTO(id, name, age));
//	4.포워딩(disapatcher(request),redirect(response))
	return new CommandAction(true, "select.do");



	
}
}
