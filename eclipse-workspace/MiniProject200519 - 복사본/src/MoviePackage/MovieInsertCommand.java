package MoviePackage;

import java.util.Scanner;

import Total.TotalCommand;

public class MovieInsertCommand implements MovieCommand{
	@Override
	public void execute(Scanner sc) {
		System.out.println("영화관 아이디를 입력하세요");
		String mvId = sc.nextLine();
		
		System.out.println("영화 제목을 입력하세요");
		String title = sc.nextLine();
		
		System.out.println("감독 이름을 입력하세요");
		String dir = sc.nextLine();
		
		System.out.println("출연 배우를 입력하세요");
		String act = sc.nextLine();
		
		System.out.println("장르를 입력하세요");
		String genre = sc.nextLine();
		
		System.out.println("관람 등급을 입력하세요");
		String age = sc.nextLine();
		
		System.out.println("러닝시간 입력하세요");
		String playTime = sc.nextLine();
		
		MovieDAO dao = new MovieDAO();
		MovieDTO dto = new MovieDTO(mvId, title, dir, act, genre, age, playTime);
		dao.insert(dto);
		
		
		
		
	}
}
