package CustomerPackage;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerDAO {

	private final String DRIVERNAME = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String UESRNAME = "ca2";
	private final String PASSWORD = "ca2";

	public CustomerDAO() {
		// TODO Auto-generated constructor stub

		try {
			Class.forName(DRIVERNAME);
			System.out.println("드라이버로딩성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버로딩실패");
			e.printStackTrace();
		}
//
//		Scanner sc = new Scanner(System.in);
//		sc.close();

	}
	
	
	public void delete(String id) {
		Connection conn =null;
		PreparedStatement pstmt = null;
		String sql ="delete from customer where id=?";
		
		try {
			
			conn =DriverManager.getConnection(URL, UESRNAME, PASSWORD);
			
		pstmt =conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally {
			
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				
				if (conn != null) {
					conn.close();
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
				// TODO: handle exception
			}
		}
		
		
		
	}

	public void update(CustomerDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update customer set name=?,pwd=?,birthDate=?,age=?,tel=? where id=?";

		try {
              conn = DriverManager.getConnection(URL, UESRNAME, PASSWORD);
              pstmt =conn.prepareStatement(sql);
              pstmt.setString(1, dto.getName());
              pstmt.setString(2, dto.getPwd());
              pstmt.setString(3, dto.getBirthDate());
              pstmt.setInt(4, dto.getAge());
              pstmt.setString(5, dto.getTel());
              pstmt.setString(6, dto.getId());
              pstmt.executeUpdate();
              
		

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
				// TODO: handle exception
			}
		}

	}

	public List<CustomerDTO> selectAll() {
		List<CustomerDTO> list = new ArrayList<CustomerDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from customer";
		ResultSet rs = null;
		try {

			conn = DriverManager.getConnection(URL, UESRNAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String birthDate = rs.getString("birthDate");
				int age = rs.getInt("age");
				String tel = rs.getString("tel");

				CustomerDTO dto = new CustomerDTO(id, pwd, name, birthDate, age, tel);

				list.add(dto);

			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
				// TODO: handle exception
			}
		}
		return list;
	}

	public void insert(CustomerDTO dto) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into customer(id,pwd,name,birthDate,age,tel) values(?,?,?,?,?,?)";

		try {

			conn = DriverManager.getConnection(URL, UESRNAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPwd());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getBirthDate());
			pstmt.setInt(5, dto.getAge());
			pstmt.setString(6, dto.getTel());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {

			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
				// TODO: handle exception
			}
		}
	}

}
