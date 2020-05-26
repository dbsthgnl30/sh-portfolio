package THEATERCommand;

import java.util.Scanner;

import THEATER.Command;
import THEATER.THDAO;

public class deleteCommand implements Command {

	@Override
	public void excute(Scanner sc) {
		System.out.println("삭제할 영화관 아이디를 입력하세요");
		String thId= sc.nextLine();
		 
		THDAO dao= new THDAO();
		dao.delete(thId);
		
	}

}
