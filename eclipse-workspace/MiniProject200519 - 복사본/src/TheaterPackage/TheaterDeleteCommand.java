package TheaterPackage;

import java.util.Scanner;

public class TheaterDeleteCommand implements TheaterCommand {

	@Override
	public void execute(Scanner sc) {
		System.out.println("삭제할 영화관 아이디를 입력하세요");
		String thId= sc.nextLine();
		 
		TheaterDAO dao= new TheaterDAO();
		dao.delete(thId);
		
	}

}
