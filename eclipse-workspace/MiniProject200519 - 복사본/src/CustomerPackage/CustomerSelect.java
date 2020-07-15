package CustomerPackage;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class CustomerSelect implements CustomerCommand {
	@Override
	public void execute(Scanner sc) {
		// TODO Auto-generated method stub
		              
		
		CustomerDAO dao =new CustomerDAO();
		 List<CustomerDTO> list = dao.selectAll();
		 
		 for( int i=0; i<list.size();i++) {
			 
			 System.out.println(list.get(i));
		 }
	
		

	}
}
