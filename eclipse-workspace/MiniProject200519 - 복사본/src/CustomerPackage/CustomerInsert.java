package CustomerPackage;

import java.util.Scanner;

public class CustomerInsert implements CustomerCommand{

	@Override
	public void execute(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("아이디를입력하세요");
		String id =sc.nextLine();
		System.out.println("패스워드를입력하세요");
		String pwd =sc.nextLine();
		System.out.println("이름을입력하세요");
		String name =sc.nextLine();
		System.out.println("생일을입력하세요");
		String birthDate= sc.nextLine();
		System.out.println("나이를입력하세요");
		int age = sc.nextInt(); sc.nextLine();
		System.out.println("전화번호를입력하세요");
		String tel =sc.nextLine();
		
		CustomerDAO dao = new CustomerDAO();
		CustomerDTO dto = new CustomerDTO(id, pwd, name, birthDate, age, tel);
		
		dao.insert(dto);
		
	}
}