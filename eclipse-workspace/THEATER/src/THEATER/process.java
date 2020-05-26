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
			System.out.println("영화관에 오신걸 환영합니다!!!");
			System.out.println("0: 입력, 1: 조회, 2: 수정, 3: 삭제, 4: 종료");
			menu = sc.nextInt();
			sc.nextLine();
			
			
			if(menu < commands.length) {
				commands[menu].excute(sc);
			} else {
				isTrue = false;
			}
			
		}
		
		System.out.println("시스템 종료");
		sc.close();
	}
}