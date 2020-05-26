package THEATER;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class THDAO {
	private final String DRIVERNAME = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USERNAME = "ca2";
	private final String PASSWORD = "ca2";

	public THDAO() {
		try {
			Class.forName(DRIVERNAME);
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}
	}

	public void insert(THDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into theater (thId,thName,thLocation,thTel) values(?,?,?,?)";

		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getThId());
			pstmt.setString(2, dto.getThName());
			pstmt.setString(3, dto.getThLocation());
			pstmt.setString(4, dto.getThTel());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
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
			}
		}
	}

	public List<THDTO> selectAll() {
		List<THDTO> list = new ArrayList<THDTO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select *from theater";
		ResultSet rs = null;

		try {
			conn=DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
//			thId,thName,thLocation,thTel
			while(rs.next()) {
				String thId= rs.getString("thId");
				String thName=rs.getString("thName");
				String thLocation= rs.getString("thLocation");
				String thTel=rs.getString("thTel");
				list.add(new THDTO(thId, thName, thLocation, thTel));
			}
		} catch (Exception e) {
			e.printStackTrace();
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
			}
		}
		return list;
	}
		public void delete(String id) {
			Connection conn=null;
			PreparedStatement pstmt= null;
			String sql="delete from theater where thid=?";
			try {
				conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.executeUpdate();
			} catch (Exception e) {
			e.printStackTrace();
			}finally {
				try {
					if (pstmt != null)
						pstmt.close();
					if (conn != null)
						conn.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		public void update(THDTO dto) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "update theater set thName=?,thLocation=?,thTel=? where thId=?";
			
			try {
				conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,dto.getThName());
				pstmt.setString(2,dto.getThLocation() );
				pstmt.setString(3, dto.getThTel());
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if (pstmt != null)
						pstmt.close();
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
}
