package Total;

import java.util.Scanner;

import CustomerPackage.CustomerProcess;
import MoviePackage.MovieProcess;
import RsvPackage.RsvProcess;
import TheaterPackage.TheaterProcess;

public class TotalProcess {
	public TotalProcess() {
		
		TotalCommand[] totalCommand = {new CustomerProcess(),
										new RsvProcess(),
										new MovieProcess(),
										new TheaterProcess()};
		
		int menu = -1;
		boolean isTrue = true;
		
		Scanner sc = new Scanner(System.in);
		
		while (isTrue) {
			System.out.println("***************************영화 예매 관리 프로그램**************************");
			System.out.println("0: 회원관리 1: 영화예매관리 2: 영화목록관리 3: 영화관 관리, 4: 종료");
			System.out.println("****************************************************************************");
			menu = sc.nextInt();
			sc.nextLine();
			
			
			if(menu < totalCommand.length) {
				totalCommand[menu].execute(sc);
			} else {
				isTrue = false;
			}
			
		}
		
		System.out.println("종료");
		sc.close();
	}
		
		
		
	}

