package com.naver;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dto.MemberDTO;

public class SelectCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.client가 보내준 데이터 획득 및 가공
		// 2. DAO 객체 생성 및 해당 메서드 호출
		MemberDAO dao= new MemberDAO();
		List<MemberDTO>list= dao.selectAll();
		
		// 3. jsp에 뿌려줄 데이터 바인딩(key,value같게 넣어준다)
		request.setAttribute("list",list);
		
		//4. forwarding 작업
		RequestDispatcher dis= request.getRequestDispatcher("select.jsp");
		dis.forward(request, response);
		

	}

}
