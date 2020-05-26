package miniproject;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CusDAO {
	private final String DRIVERNAME = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USERNAME = "CA2";
	private final String PASSWORD = "ca2";
	

	public CusDAO() {
	try {
		
		Class.forName(DRIVERNAME);
	} catch (Exception e) {
		e.printStackTrace();// TODO: handle exception
	}// TODO Auto-generated constructor stub
	}
	
	public void insert(CusDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into table customer(id,pwd,name,birthDate,age,tel) values(?,?,?,?,?,?)";
		
		try {
			conn=DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
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
			}
		}
	}
	public List<CusDTO> selectAll() {
		List<CusDTO> list = new ArrayList<CusDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from tbl_member";
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt(3);
				
				MemberDTO dto = new MemberDTO(id, name, age);
				list.add(dto);
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
		return list;
	}

}
