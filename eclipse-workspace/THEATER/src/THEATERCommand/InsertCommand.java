package THEATERCommand;

import java.util.Scanner;

import THEATER.Command;
import THEATER.THDAO;
import THEATER.THDTO;

public class InsertCommand implements Command {

	@Override
	public void excute(Scanner sc) {
		
		System.out.println("��ȭ�� ���̵� �Է��ϼ���");
		String thId= sc.nextLine();
		
		System.out.println("��ȭ�� �̸��� �Է��ϼ���");
		String thName= sc.nextLine();

		System.out.println("��ȭ�� ��ġ�� �Է��ϼ���");
		String thLocation= sc.nextLine();
		
		System.out.println("��ȭ�� ��ȭ��ȣ�� �Է��ϼ���");
		String thTel= sc.nextLine();
	
		THDAO dao= new THDAO();
		THDTO dto= new THDTO(thId, thName, thLocation, thTel);
		dao.insert(dto);
		
	}

}
