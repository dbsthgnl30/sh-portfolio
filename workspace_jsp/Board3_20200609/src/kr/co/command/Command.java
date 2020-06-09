package kr.co.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.domain.CommandAaction;

public interface Command {
	CommandAaction execute(HttpServletRequest request,
							HttpServletResponse reponse)
								throws ServletException, IOException;
}
