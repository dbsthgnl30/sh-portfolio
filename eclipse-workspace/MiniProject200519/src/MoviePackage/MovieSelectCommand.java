package MoviePackage;

import java.util.List;
import java.util.Scanner;

import Total.TotalCommand;

public class MovieSelectCommand implements MovieCommand{
	@Override
	public void execute(Scanner sc) {
		MovieDAO dao = new MovieDAO();
		List<MovieDTO> list = dao.selectAll();
		
		for(int i = 0; i < list.size(); i ++) {
			System.out.println(list.get(i));
		}
		
	}
}
