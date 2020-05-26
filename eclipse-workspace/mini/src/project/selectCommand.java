
package project;

import java.util.List;
import java.util.Scanner;

import mini.Command;
import mini.rsvDAO;
import mini.rsvDTO;

public class selectCommand implements Command {

	
	@Override
	public void execute(Scanner sc) {
	rsvDAO dao= new rsvDAO();
	List<rsvDTO> list= dao.selectAll();
	
	for(int i=0; i<list.size(); i++) {
		System.out.println(list.get(i));
	}
	
	
		
	}

}
