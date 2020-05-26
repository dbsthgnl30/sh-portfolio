package RsvPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class rsvDAO {

	private final String DRIVERNAME = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String UESRNAME = "ca2";
	private final String PASSWORD = "ca2";

	////// sql 주소 안씀.
	/// update get 수정 요함

	public rsvDAO() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName(DRIVERNAME);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void delete(String rsv_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from rsv where rsv_id = ?";

		try {

			conn = DriverManager.getConnection(URL, UESRNAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rsv_id);
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

	public void update(rsvDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update rsv set cus_id = ?, mv_mvId =?,th_thId =?,day=?,rsvTime=?, num=?,paymentMethod=?,total=? where rsv_id=?";
		try {

			conn = DriverManager.getConnection(URL, UESRNAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(9, dto.getRsv_id());
			pstmt.setString(1, dto.getCus_id());
			pstmt.setString(2, dto.getMv_mvId());
			pstmt.setString(3, dto.getTh_thId());
			pstmt.setString(4, dto.getDay());
			pstmt.setString(5, dto.getRsvTime());
			pstmt.setInt(6, dto.getNum());
			pstmt.setString(7, dto.getPaymentMethod());
			pstmt.setInt(8, dto.getTotal());
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

	public List<rsvDTO> selectAll() {
		List<rsvDTO> list = new ArrayList<rsvDTO>();
		Connection conn = null;
		PreparedStatement pstmr = null;
		String sql = "select * from rsv";
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(URL, UESRNAME, PASSWORD);
			pstmr = conn.prepareStatement(sql);
			rs = pstmr.executeQuery();

			while (rs.next()) {
				String rsv_id = rs.getString("rsv_id");
				String cus_id = rs.getString("cus_id");				
				String mv_mvId = rs.getString("mv_mvId");
				String th_thId = rs.getString("th_thId");
				String day = rs.getString("day");
				String rsvTime = rs.getString("rsvTime");
				int num = rs.getInt("num");
				String paymentMethod = rs.getString("paymentMethod");
				int total = rs.getInt("total");
				rsvDTO dto = new rsvDTO(rsv_id, cus_id, mv_mvId, th_thId, day, rsvTime, num, paymentMethod, total);
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
				if (pstmr != null) {
					pstmr.close();
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

	public void insert(rsvDTO dto) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into rsv (rsv_id, cus_id, mv_mvId, th_thId, day, rsvTime, num, paymentMethod, total) values (?,?,?,?,?,?,?,?,?)";
		try {
			conn = DriverManager.getConnection(URL, UESRNAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getRsv_id());
			pstmt.setString(2, dto.getCus_id());
			pstmt.setString(3, dto.getMv_mvId());
			pstmt.setString(4, dto.getTh_thId());
			pstmt.setString(5, dto.getDay());
			pstmt.setString(6, dto.getRsvTime());
			pstmt.setInt(7, dto.getNum());
			pstmt.setString(8, dto.getPaymentMethod());
			pstmt.setInt(9, dto.getTotal());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			try {

			} catch (Exception e2) {
				e2.printStackTrace();
				// TODO: handle exception
			}
		}
	}
}
