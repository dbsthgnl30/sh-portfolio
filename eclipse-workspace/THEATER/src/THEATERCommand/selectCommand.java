package THEATERCommand;

import java.util.List;
import java.util.Scanner;

import THEATER.Command;
import THEATER.THDAO;
import THEATER.THDTO;

public class selectCommand   implements Command{

	@Override
	public void excute(Scanner sc) {
		THDAO dao= new THDAO();
		List<THDTO> list= dao.selectAll();
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}

}
