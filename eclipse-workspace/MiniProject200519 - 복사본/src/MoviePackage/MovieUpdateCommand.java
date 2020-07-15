package MoviePackage;

import java.util.Scanner;

import Total.TotalCommand;

public class MovieUpdateCommand implements MovieCommand{
	@Override
	public void execute(Scanner sc) {
		System.out.println("영화관 아이디를 입력하세요");
		String mvId = sc.nextLine();
		
		System.out.println("수정될 영화 제목을 입력하세요");
		String title = sc.nextLine();
		
		System.out.println("수정될 감독 이름을 입력하세요");
		String dir = sc.nextLine();
		
		System.out.println("수정될 출연 배우를 입력하세요");
		String act = sc.nextLine();
		
		System.out.println("수정될 장르를 입력하세요");
		String genre = sc.nextLine();
		
		System.out.println("수정될 권장 연령을 입력하세요");
		String age = sc.nextLine();
		
		System.out.println("수정될 상영시간 입력하세요");
		String playTime = sc.nextLine();
		
		MovieDAO dao = new MovieDAO();
		MovieDTO dto = new MovieDTO(mvId, title, dir, act, genre, age, playTime);
		dao.update(dto);
		
	}
}
