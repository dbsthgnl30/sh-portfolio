package THEATERCommand;

import java.util.Scanner;

import THEATER.Command;
import THEATER.THDAO;

public class deleteCommand implements Command {

	@Override
	public void excute(Scanner sc) {
		System.out.println("������ ��ȭ�� ���̵� �Է��ϼ���");
		String thId= sc.nextLine();
		 
		THDAO dao= new THDAO();
		dao.delete(thId);
		
	}

}
