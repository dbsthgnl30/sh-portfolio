package kr.co.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.domain.MemberDTO;
import kr.co.persistence.MemberDAO;

@Service
@Transactional
public class MemberServiceImpl implements MemberService{
	@Inject
	private MemberDAO memberDao;

	@Override
	public void insert(MemberDTO dto) {
		memberDao.insert(dto);
		
	}

	@Override
	public List<MemberDTO> list() {
		// TODO Auto-generated method stub
		return memberDao.list();
	}

	@Override
	public MemberDTO read(String id) {
		// TODO Auto-generated method stub
		return memberDao.read(id);
	}

	@Override
	public MemberDTO updateui(String id) {
		// TODO Auto-generated method stub
		return memberDao.updateui(id);
	}

	@Override
	public void upate(MemberDTO dto) {
	memberDao.update(dto);
	
	}

	@Override
	public void delete(String id) {
	memberDao.delete(id);
		
	}
	

	
}
