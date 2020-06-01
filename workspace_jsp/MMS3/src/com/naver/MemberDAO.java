package com.naver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDAO {
	private DataSource dataFactory;

	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			dataFactory = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle11g");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // TODO Auto-generated constructor stub
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
					conn.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

	public void insert(MemberDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into member(id,name,age,pw) values(?,?,?,?)";
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getAge());
			pstmt.setString(4, dto.getPw());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			closeAll(null, pstmt, conn);
		}
	}

	public List<MemberDTO> selectAll() {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from member order by id asc";
		ResultSet rs = null;

		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				list.add(new MemberDTO(id, null, name, age));

			}
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		} finally {
			closeAll(rs, pstmt, conn);
		}
		return list;

	}

	public void update(MemberDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update member set name=?,age=? where id=? and pw=?";
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getAge());
			pstmt.setString(3, dto.getId());
			pstmt.setString(4, dto.getPw());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		} finally {
			closeAll(null, pstmt, conn);
		}
	}

	public void delete(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from member where id=?";
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			closeAll(null, pstmt, conn);
		}
	}

	public MemberDTO selectById(String id) {
		MemberDTO dto= null;
		Connection conn= null;
		PreparedStatement pstmt= null;
		String sql= "select *from member where id=?";
		ResultSet rs= null;
		
		try {
			conn=dataFactory.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				String name= rs.getString("name");
//				String pw=rs.getString("pw");
				int age=rs.getInt("age");
				dto=new MemberDTO(id, null, name, age);
			}
			
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}finally {
			closeAll(rs, pstmt, conn);
		}
		return dto;
	}

	public MemberDTO updateUI(String id) {
		// TODO Auto-generated method stub
		return selectById(id);
	}

	public boolean login(LoginDTO loginDTO) {
		boolean login =false;
		Connection conn= null;
		PreparedStatement pstmt= null;
		String sql= "select *from member where id=? and pw=?";
		ResultSet rs=null;
		try {
			conn=dataFactory.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, loginDTO.getId());
			pstmt.setString(2, loginDTO.getPw());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				login= true;
			}
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}finally {
			closeAll(rs, pstmt, conn);
		}
		return login;
	}

	
} 
