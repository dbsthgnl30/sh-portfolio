package project;

import java.util.Scanner;

import mini.Command;
import mini.rsvDAO;
import mini.rsvDTO;

public class insertCommand  implements Command {

	@Override
	public void execute(Scanner sc) {
		System.out.println("아이디를 입력하세요.");
		String id = sc.nextLine();
		
		System.out.println("이름을 입력하세요");
		String name= sc.nextLine();
		
		System.out.println("상영할 영화관을 입력하세요");
		String theater=sc.nextLine();
		
		System.out.println("상영할 영화를  입력하세요");
		String title=sc.nextLine();
		
		System.out.println("상영할 날짜를  입력하세요");
		String day= sc.nextLine();
		
		System.out.println("인원수를  입력하세요");
		int howmany=sc.nextInt();
		sc.nextLine();
		
		System.out.println("가격을 입력하세요");
		int cost=sc.nextInt();
		sc.nextLine();
		
		System.out.println("좌석번호를 입력하세요");
		String seatNumber=sc.nextLine();
		
		rsvDTO dto= new rsvDTO(id, name, title, theater, day, howmany, cost, seatNumber);
		rsvDAO dao= new rsvDAO();
		dao.insert(dto);
	}

}
