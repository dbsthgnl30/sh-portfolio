package TheaterPackage;



import java.util.Scanner;



public class TheaterInsertCommand implements TheaterCommand {

	@Override
	public void execute(Scanner sc) {
		
		System.out.println("영화관 아이디를 입력하세요");
		String thId= sc.nextLine();
		
		System.out.println("영화관 이름을 입력하세요");
		String thName= sc.nextLine();

		System.out.println("영화관 위치를 입력하세요");
		String thLocation= sc.nextLine();
		
		System.out.println("영화관 전화번호 입력하세요");
		String thTel= sc.nextLine();
	
		TheaterDAO dao= new TheaterDAO();
		TheaterDTO dto= new TheaterDTO(thId, thName, thLocation, thTel);
		dao.insert(dto);
		
	}

}
