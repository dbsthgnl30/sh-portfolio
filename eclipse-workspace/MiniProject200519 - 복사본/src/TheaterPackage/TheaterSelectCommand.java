package TheaterPackage;



import java.util.List;
import java.util.Scanner;


public class TheaterSelectCommand   implements TheaterCommand{

	@Override
	public void execute(Scanner sc) {
		TheaterDAO dao= new TheaterDAO();
		List<TheaterDTO> list= dao.selectAll();
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}

}
