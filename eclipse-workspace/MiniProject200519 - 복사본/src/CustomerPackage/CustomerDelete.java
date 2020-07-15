package CustomerPackage;

import java.util.Scanner;

public class CustomerDelete  implements CustomerCommand{
@Override
public void execute(Scanner sc) {
	// TODO Auto-generated method stub
	         
	System.out.println("삭제할 아이디를 선택하세요");
	String id =sc.nextLine();
	
	
	CustomerDAO dao =new CustomerDAO();
	dao.delete(id);
}
}
