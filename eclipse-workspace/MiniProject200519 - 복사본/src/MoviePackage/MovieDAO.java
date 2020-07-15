package MoviePackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO {

	private final String DRIVERNAME = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USERNAME = "ca2";
	private final String PASSWORD = "ca2";

	public MovieDAO() {
		try {
			Class.forName(DRIVERNAME);
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패"); 
			e.printStackTrace(); 
		}
	}
	
	//delete
	public void delete(String mvId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM movie WHERE mvId = ?";

		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("connection success");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mvId);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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

	
	//update
	public void update(MovieDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE movie SET title = ?, dir = ?, act = ?, genre = ?, age = ?,playTime=? WHERE mvId = ?"; 
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("커넥션 연결성공");

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(7, dto.getMvId());
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getDir());
			pstmt.setString(3, dto.getAct());
			pstmt.setString(4, dto.getGenre());
			pstmt.setString(5, dto.getAge());
			pstmt.setString(6, dto.getPlayTime());
			

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
	
	//select
	public List<MovieDTO> selectAll() {
		List<MovieDTO> list = new ArrayList<MovieDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from movie";
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("connection success");
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String mvId = rs.getString(1);
				String title = rs.getString(2);
				String dir = rs.getString(3);
				String act = rs.getString(4);
				String genre = rs.getString(5);
				String age = rs.getString(6);
				String playTime = rs.getString(7);
				
				MovieDTO dto = new MovieDTO(mvId, title, dir, act, genre, age, playTime);
				list.add(dto);
				
			}
			
			
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
		return list;
	}
	
	//insert
	public void insert(MovieDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into movie(mvId,title,dir,act,genre,age,playTime) values(?,?,?,?,?,?,?)";
		
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("connection success");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMvId());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getDir());
			pstmt.setString(4, dto.getAct());
			pstmt.setString(5, dto.getGenre());
			pstmt.setString(6, dto.getAge());
			pstmt.setString(7, dto.getPlayTime());
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
}
