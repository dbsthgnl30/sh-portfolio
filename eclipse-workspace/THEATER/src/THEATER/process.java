package THEATER;

import java.util.Scanner;

import THEATERCommand.InsertCommand;
import THEATERCommand.deleteCommand;
import THEATERCommand.selectCommand;
import THEATERCommand.updateCommand;



public class process {
	public process() {
		Command[] commands = {new InsertCommand(),
							new selectCommand(),
							new updateCommand(),
							new deleteCommand()
							};
		
		int menu = -1;
		boolean isTrue = true;
		
		Scanner sc = new Scanner(System.in);
		
		while (isTrue) {
			System.out.println("��ȭ���� ���Ű� ȯ���մϴ�!!!");
			System.out.println("0: �Է�, 1: ��ȸ, 2: ����, 3: ����, 4: ����");
			menu = sc.nextInt();
			sc.nextLine();
			
			
			if(menu < commands.length) {
				commands[menu].excute(sc);
			} else {
				isTrue = false;
			}
			
		}
		
		System.out.println("�ý��� ����");
		sc.close();
	}
}