package MoviePackage;

import java.util.Scanner;

import Total.TotalCommand;

public class MovieDeleteCommand implements MovieCommand {
	@Override
	public void execute(Scanner sc) {
			System.out.println("삭제할 영화관 아이디를 입력하세요");
			String id = sc.nextLine();
			
			MovieDAO dao = new MovieDAO();
			dao.delete(id);
					
		
	}
}
