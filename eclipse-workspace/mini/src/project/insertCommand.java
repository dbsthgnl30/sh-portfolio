package project;

import java.util.Scanner;

import mini.Command;
import mini.rsvDAO;
import mini.rsvDTO;

public class insertCommand  implements Command {

	@Override
	public void execute(Scanner sc) {
		System.out.println("���̵� �Է��ϼ���.");
		String id = sc.nextLine();
		
		System.out.println("�̸��� �Է��ϼ���");
		String name= sc.nextLine();
		
		System.out.println("���� ��ȭ���� �Է��ϼ���");
		String theater=sc.nextLine();
		
		System.out.println("���� ��ȭ��  �Է��ϼ���");
		String title=sc.nextLine();
		
		System.out.println("���� ��¥��  �Է��ϼ���");
		String day= sc.nextLine();
		
		System.out.println("�ο�����  �Է��ϼ���");
		int howmany=sc.nextInt();
		sc.nextLine();
		
		System.out.println("������ �Է��ϼ���");
		int cost=sc.nextInt();
		sc.nextLine();
		
		System.out.println("�¼���ȣ�� �Է��ϼ���");
		String seatNumber=sc.nextLine();
		
		rsvDTO dto= new rsvDTO(id, name, title, theater, day, howmany, cost, seatNumber);
		rsvDAO dao= new rsvDAO();
		dao.insert(dto);
	}

}
