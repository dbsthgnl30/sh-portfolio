package THEATERCommand;

import java.util.Scanner;

import THEATER.Command;
import THEATER.THDAO;
import THEATER.THDTO;

public class InsertCommand implements Command {

	@Override
	public void excute(Scanner sc) {
		
		System.out.println("영화관 아이디를 입력하세요");
		String thId= sc.nextLine();
		
		System.out.println("영화관 이름를 입력하세요");
		String thName= sc.nextLine();

		System.out.println("영화관 위치를 입력하세요");
		String thLocation= sc.nextLine();
		
		System.out.println("영화관 전화번호를 입력하세요");
		String thTel= sc.nextLine();
	
		THDAO dao= new THDAO();
		THDTO dto= new THDTO(thId, thName, thLocation, thTel);
		dao.insert(dto);
		
	}

}
