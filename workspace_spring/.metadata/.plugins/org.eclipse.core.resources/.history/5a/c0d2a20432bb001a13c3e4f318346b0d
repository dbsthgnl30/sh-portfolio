package kr.co.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.domain.MemberDTO;
import kr.co.service.MemberService;

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Autowired
	private SqlSession session;

	private final String NS = "m.e.m";

	@Override
	public void insert(MemberDTO dto) {
		session.insert(NS+".insert", dto);
		
	}

	@Override
	public List<MemberDTO> list() {
		
		return session.selectList(NS+".list");
	}

}
