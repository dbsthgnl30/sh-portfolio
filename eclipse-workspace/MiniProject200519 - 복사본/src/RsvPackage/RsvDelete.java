package RsvPackage;


import java.util.Scanner;

import Total.TotalCommand;




public class RsvDelete implements RsvCommand {
	@Override
	public void execute(Scanner sc) {
		// TODO Auto-generated method stub
             
		System.out.println("삭제할 아이디를 선택하셈");
		String rsv_id =sc.nextLine();
		
		
		rsvDAO dao =new rsvDAO();
		dao.delete(rsv_id);
	}
}
