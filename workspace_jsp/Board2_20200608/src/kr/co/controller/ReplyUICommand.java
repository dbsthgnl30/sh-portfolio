package kr.co.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.command.Command;
import kr.co.domain.CommandAaction;

public class ReplyUICommand implements Command {

	@Override
	public CommandAaction execute(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		String num= request.getParameter("num");
		
		return new CommandAaction(false, "reply.jsp?num="+num);
	}

}
