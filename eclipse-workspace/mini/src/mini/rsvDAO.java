package mini;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class rsvDAO implements  Serializable{
	private final String DRIVERNAME = "oracle.jdbc.driver.OracleDriver";
	
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USERNAME = "CA2";
	private final String PASSWORD = "ca2";
	
	public rsvDAO() {
	try {
		Class.forName(DRIVERNAME);
	} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	}
	
	}
	public void  insert(rsvDTO dto){
		Connection conn= null;
		PreparedStatement pstmt= null;
		 String sql="insert into table movieTest (id,name,title,theater,day,howmany,cost,seatnumber) values(?,?,?,?,?,?,?,?)";
		 
		try {
			conn=DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt=conn.prepareStatement(sql);
			 pstmt.setString(1, dto.getId());
			 pstmt.setString(1, dto.getName());
			 pstmt.setString(1, dto.getTitle());
			 pstmt.setString(1, dto.getTheater());
			 pstmt.setString(1, dto.getDay());
			 pstmt.setInt(1, dto.getHowmany());
			 pstmt.setInt(1, dto.getCost());
			 pstmt.setString(1, dto.getSeatNumber());
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null)  pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public List<rsvDTO> selectAll() {
		List<rsvDTO> list= new ArrayList<rsvDTO>();
		Connection conn=null;
		PreparedStatement pstmt= null;
		String sql="select *from movieTest";
		ResultSet rs=null;
		
		try {
			conn=DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				String id= rs.getString("id");
				String name=rs.getString("name");
				String title= rs.getString("title");
				String theater=rs.getString("theater");
				String day=rs.getString("day");
				int howmany=rs.getInt(3);
				int cost= rs.getInt(30000);
				String seatnumber=rs.getString("seatnumber");
				}
			
		} catch (Exception e) {
				e.printStackTrace();
		}finally {
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
	
	public void update(rsvDTO dto) {
		Connection conn=null;
		PreparedStatement pstmt= null;
		String sql= "update table movieTest set title=?,theater=?,day=?,howmany=?,sesatNumber=? where id=?";
		
		try {
			conn=DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,dto.getTitle());
			pstmt.setString(2, dto.getTheater());
			pstmt.setString(3, dto.getDay());
			pstmt.setInt(4, dto.getHowmany());
			pstmt.setString(5, dto.getSeatNumber());
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();	
			} catch (Exception e2) {
			e2.printStackTrace();
			}
		}
	}
	
	
	public void delete(String id) {
		Connection conn= null;
		PreparedStatement pstmt= null;
		String sql= "delete from table movieTest where id=?";
		
		try {
			conn=DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
