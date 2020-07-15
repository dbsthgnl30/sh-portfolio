package RsvPackage;


import java.util.List;
import java.util.Scanner;


import Total.TotalCommand;

public class RsvSelect implements RsvCommand{
	@Override
	public void execute(Scanner sc) {
		// TODO Auto-generated method stub

		rsvDAO dao = new rsvDAO();
		List<rsvDTO> list = dao.selectAll();

		for (int i = 0; i < list.size(); i++) {

			System.out.println(list.get(i));
		}

	}
}
