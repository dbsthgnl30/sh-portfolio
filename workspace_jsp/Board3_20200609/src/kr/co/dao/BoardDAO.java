package kr.co.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.co.domain.BoardDTO;
import kr.co.domain.PageTO;
import sun.font.CreatedFontTracker;

public class BoardDAO {
	private DataSource datafactory;

	public BoardDAO() {
		try {
			Context ctx = new InitialContext();
			datafactory = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle11g");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {

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
			e2.printStackTrace();// TODO: handle exception
		}

	}

	public List<BoardDTO> list() {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from board order by repRoot desc, repStep asc";
		ResultSet rs = null;

		try {
			conn = datafactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int num = rs.getInt("num");
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				String writeday = rs.getString("writeday");
				int readcnt = rs.getInt("readcnt");
				int repRoot = rs.getInt("repRoot");
				int repStep = rs.getInt("repStep");
				int repIndent = rs.getInt("repIndent");

				list.add(new BoardDTO(num, writer, title, null, writeday, readcnt, repRoot, repStep, repIndent));

			}

		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		} finally {
			closeAll(rs, pstmt, conn);
		}

		return list;
	}

	public void insert(BoardDTO boardDTO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into board (num,writer,title,content,repRoot,repStep,repIndent) values(?,?,?,?,?,?,?)";

		try {
			conn = datafactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			int num = createNum(conn);

			pstmt.setInt(1, num);
			pstmt.setString(2, boardDTO.getWriter());
			pstmt.setString(3, boardDTO.getTitle());
			pstmt.setString(4, boardDTO.getContent());
			pstmt.setInt(5, num);
			pstmt.setInt(6, 0);
			pstmt.setInt(7, 0);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace(); // TODO: handle exception
		} finally {
			closeAll(null, pstmt, conn);//rs닫지마세여
		}

	}

	private int createNum(Connection conn) {
		PreparedStatement pstmt = null;
		String sql = "select max(num) from board";
		ResultSet rs = null;
		Integer num = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				num = rs.getInt(1);
				num += 1;
			}
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		} finally {
			closeAll(rs, pstmt, null);

		}

		return num;
	}
	public BoardDTO read(int num) {
		
		BoardDTO dto= null;
		Connection conn= null;
		PreparedStatement pstmt= null;
		String sql="select * from board where num=?";
		 ResultSet rs= null;
		 boolean isOk=false;
		 
		try {
			conn=datafactory.getConnection();
			conn.setAutoCommit(false);
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rs= pstmt.executeQuery();
		 increaseReadCnt(conn,num);
				
			if(rs.next()) {
				String writer= rs.getString("writer");
				String title= rs.getString("title");
				String writeday= rs.getString("writeday");
				int readcnt= rs.getInt("readcnt");
				String content=rs.getString("content");
				//글자세히 보기에선 들여쓰기 등등 볼필요없어서 0으로
				dto= new BoardDTO(num, writer, title, content, writeday, readcnt, 0, 0, 0);
				
				isOk=true;
				
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				if(isOk) {
					conn.commit();
					
				}else {
					conn.rollback();
				}
			} catch (SQLException e) {
				e.printStackTrace();// TODO: handle exception
			}
			closeAll(rs, pstmt, conn);
		}
		return dto;
		
	}

	private int increaseReadCnt(Connection conn, int num) {
		PreparedStatement pstmt= null;
		String sql="update board set readcnt=readcnt+1 where num=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}finally {
			closeAll(null, pstmt, null);
		}
		
		return 0;
	}

	public BoardDTO updateUI(int num) {
		BoardDTO dto= null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="select *from board where num=?";
		ResultSet rs= null;
		
		try {
			conn=datafactory.getConnection();
		
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				String writer= rs.getString("writer");
				String title= rs.getString("title");
				String content=rs.getString("content");
				int repRoot= rs.getInt("repRoot");
				int repStep=rs.getInt("repStep");
				int repIndent=rs.getInt("repIndent");
				//글자세히 보기에선 들여쓰기 등등 볼필요없어서 0으로
				dto= new BoardDTO(num, writer, title, content, null	, 0, repRoot, repStep,repIndent);
			}
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}finally {
			closeAll(rs, pstmt, conn);
		}
		return dto;
	}

	public void update(BoardDTO boardDTO) {
		Connection conn= null;
		PreparedStatement pstmt= null;
		String sql="update board set writer=?,title=?,content=? where num=?";
		
		try {
			conn=datafactory.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,boardDTO.getWriter() );
			pstmt.setString(2, boardDTO.getTitle());
			pstmt.setString(3, boardDTO.getContent());
			pstmt.setInt(4, boardDTO.getNum());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			closeAll(null, pstmt, conn);
		}
		
	}

	public void delete(int num) {
		Connection conn= null;
		PreparedStatement pstmt= null;
		String sql="delete from board where num=?";
		try {
			conn=datafactory.getConnection();
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}finally {
			closeAll(null, pstmt, conn);
		}
		
	}

	public void reply(int orgnum, BoardDTO dto) {
		Connection conn= null;
		PreparedStatement pstmt= null;
		String sql="insert into board (num, writer, title,content,repRoot,repStep,repIndent)values(?,?,?,?,?,?,?)";
		
		boolean isOk=false;
		
		
		
		try {
			conn=datafactory.getConnection();
			conn.setAutoCommit(false);
			
			int num= createNum(conn);
			
			BoardDTO orgDTO= updateUI(orgnum);//repRoot/repStep/repIndent다이씀
			
			stepPlus1(conn,orgDTO);
			
			
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, dto.getWriter());
			pstmt.setString(3,dto.getTitle());
			pstmt.setString(4, dto.getContent());
			pstmt.setInt(5,orgDTO.getRepRoot());
			pstmt.setInt(6,orgDTO.getRepStep()+1);
			pstmt.setInt(7,orgDTO.getRepIndent()+1);//부모가 0이면 답글은 +1
			pstmt.executeUpdate();
			
			
			isOk=true;
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}finally {
			try {
				if (isOk) {
					conn.commit();
				} else {
					conn.rollback();
				} 
			} catch (Exception e2) {
				e2.printStackTrace();// TODO: handle exception
			}
			closeAll(null, pstmt, conn);
		}
		
	}
	//repRoot값이 같은 다른 답글이있는지 확인해서 원글의 repStep값보다 큰  repStep값을 변경 repStep+1
	private void stepPlus1(Connection conn, BoardDTO orgDTO) {
	PreparedStatement pstmt= null;						//부모의 repRoot repStep값							
	String sql="update board set repStep=repStep+1 where repRoot=? and repStep>?";
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, orgDTO.getRepRoot());
			pstmt.setInt(2, orgDTO.getRepStep());
			
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}finally {
			closeAll(null, pstmt, null);
		}
	}

	public PageTO page(int curPage) {
		String sql="select *from (select rownum rnum,num,title,writer,writeday,readcnt,repIndent from(select * from board order by repRoot desc, repStep asc))where rnum>=? and rnum<=?";
		PageTO to=new PageTO(curPage);
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		Connection conn=null;
		PreparedStatement pstmt= null;
		ResultSet rs=null;
		
		try {
			conn=datafactory.getConnection();
			int amount= getAmount(conn);
			to.setAmount(amount);
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, to.getStartnum());
			pstmt.setInt(2, to.getEndnum());
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				int num=rs.getInt("num");
				String title=rs.getString("title");
				String writer=rs.getString("writer");
				String writeday=rs.getString("writeday");
				int readcnt=rs.getInt("readcnt");
				int repIndent= rs.getInt("repIndent");
				BoardDTO dto= new BoardDTO(num, writer, title, null, writeday, readcnt, -1, -1, repIndent);
				list.add(dto);
			}
			to.setList(list);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(rs, pstmt, conn);
		}
		
		
		return to;
	}
	private int getAmount(Connection conn) {
		int amount=0;
		
		PreparedStatement pstmt=null;
		String sql="select count(num) from board";
		ResultSet rs=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				amount =rs.getInt(1);
				 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(rs, pstmt, null);
		}
		
		
		return amount;
		
	}

}
