package com.naver;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dao.MemberDAO;
import kr.co.domain.MemberDTO;

//목록보기
public class SelectCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//	1번 패스
//		2번
		MemberDAO dao= new MemberDAO();
		List<MemberDTO> list= dao.selectAll();
//		3번 데이터 바인딩 list라는 이름으로 받음
		request.setAttribute("list", list);
		//4번 dispatcher 데이터 보존을 위해
		return new CommandAction(true, "select.jsp");
	}

}
