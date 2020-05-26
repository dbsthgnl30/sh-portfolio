package TheaterPackage;

import java.util.Scanner;

public class TheaterUpdateCommand implements TheaterCommand{

	@Override
	public void execute(Scanner sc) {
		System.out.println("수정할 영화관 아이디 입력하세요");
		String thId= sc.nextLine();
		
		System.out.println("수정될 영화관 이름 입력하세요");
		String thName= sc.nextLine();

		System.out.println("수정될 영화관 위치 입력하세요");
		String thLocation= sc.nextLine();
		
		System.out.println("수정될 영화관 전화번호 입력하세요");
		String thTel= sc.nextLine();
		
		TheaterDTO dto =new TheaterDTO(thId, thName, thLocation, thTel);
		TheaterDAO dao = new TheaterDAO();
		dao.update(dto);
	
	}

}
