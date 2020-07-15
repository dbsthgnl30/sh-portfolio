package RsvPackage;

import java.util.Scanner;

import Total.TotalCommand;



public class RsvUpdate implements RsvCommand {
	@Override
	public void execute(Scanner sc) {
		// TODO Auto-generated method stub
		
		////수정할꺼  선택해야댐.
		
		
		
		System.out.println("수정될rsv아이디");
		String rsv_id =sc.nextLine();
		System.out.println("수정될cus아이디");
		String cus_id =sc.nextLine();
		System.out.println("수정될mvid");
		String mv_mvId =sc.nextLine();
		System.out.println("수정될thid");
		String th_thId= sc.nextLine();
		System.out.println("num");
		int num = sc.nextInt(); sc.nextLine();
		System.out.println("day");
		String day =sc.nextLine();
		System.out.println("rsv_Time");
		String rsvTime =sc.nextLine();
		System.out.println("paymentmethod");
		String paymentMethod =sc.nextLine();
		System.out.println("total");
		int total = sc.nextInt();sc.nextLine();
		
        
      
        rsvDTO dto = new rsvDTO(rsv_id, cus_id, mv_mvId, th_thId, day, rsvTime, num, paymentMethod, total);
        rsvDAO dao =new rsvDAO();
        dao.update(dto);
        
        
	}
}
