package kr.co.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.co.domain.MemberDTO;

public class MemberDAO {
	private DataSource dataFactory;

	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			dataFactory = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle11g");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		try {

		} catch (Exception e) {
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
				}
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void insert(MemberDTO dto) {
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into member(id,name,age) values(?,?,?)";
		try {
			conn = dataFactory.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getAge());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		} finally {
			closeAll(null, pstmt, conn);
		}
		
	}
	public List<MemberDTO> selectAll(){
		List<MemberDTO> list =new ArrayList<MemberDTO>();
		Connection conn= null;
		PreparedStatement pstmt=null;
		String sql="select id, name 이름, age 나이  from member";
		ResultSet rs=null;
	
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString("이름");
				int age = rs.getInt("나이");
				list.add(new MemberDTO(id, name, age));
			}
			
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}finally {
		closeAll(rs, pstmt, conn);
		
		}
		return list;
	}
	public void update(MemberDTO dto) {
		Connection conn=null;
		PreparedStatement pstmt= null;
		String sql="update  member ser name=?,age=? where id=?";
		try {
			conn= dataFactory.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getAge());
			pstmt.setString(3, dto.getId());
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}finally {
			try {
				if(pstmt !=null) {
					pstmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();// TODO: handle exception
			}
		}
	}
	public void delete(String id) {
		Connection conn=null;
		PreparedStatement pstmt= null;
		 String sql="delete from member where id=?";
		 
		 try {
			conn=dataFactory.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}finally {
			try {
				
			} catch (Exception e2) {
				e2.printStackTrace();// TODO: handle exception
			}
		}
				 
	}
}
