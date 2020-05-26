package RsvPackage;




import java.util.Scanner;

import Total.TotalCommand;

public class RsvInsert  implements RsvCommand{
@Override
public void execute(Scanner sc) {
	// TODO Auto-generated method stub
	  
	
	
	///////   sout 안에 출력문구 입력 요함
	
	System.out.println("rsv아이디");
	String rsv_id =sc.nextLine();
	System.out.println("cus아이디");
	String cus_id =sc.nextLine();
	System.out.println("mvid");
	String mv_mvid =sc.nextLine();
	System.out.println("thid");
	String th_thid= sc.nextLine();
	System.out.println("num");
	int num = sc.nextInt(); sc.nextLine();
	System.out.println("day");
	String day =sc.nextLine();
	System.out.println("rsv_Time");
	String rsv_Time =sc.nextLine();
	System.out.println("paymentmethod");
	String paymentmethod =sc.nextLine();
	System.out.println("total");
	int total = sc.nextInt();sc.nextLine();
	
	
	rsvDAO dao = new rsvDAO();
	rsvDTO dto = new rsvDTO(rsv_id, cus_id, mv_mvid, th_thid, day, rsv_Time, num, paymentmethod, total);
	
	dao.insert(dto);
}
}
