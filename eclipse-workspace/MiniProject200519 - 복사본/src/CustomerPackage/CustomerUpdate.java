package CustomerPackage;

import java.util.Scanner;

public class CustomerUpdate implements CustomerCommand {
	@Override
	public void execute(Scanner sc) {
		// TODO Auto-generated method stub

		System.out.println("수정할 아이디를입력하세요");
		String id = sc.nextLine();
        System.out.println("수정될 패스워드를입력하세요");
        String pwd= sc.nextLine();
        System.out.println("수정될 생일을입력하세요");
        String birthDate = sc.nextLine();
        System.out.println("수정될 이름을 입력하세요");
        String name = sc.nextLine();
        System.out.println("수정될 나이를입력하세요 ");
        int age = sc.nextInt();sc.nextLine();
        System.out.println("수정될 전화번호를입력하세요");
        String tel =sc.nextLine();
        
        CustomerDTO dto =new CustomerDTO(id, pwd, name, birthDate, age, tel);
        
        CustomerDAO dao =new CustomerDAO();
        dao.update(dto);
        
        
      
    
	}
}
