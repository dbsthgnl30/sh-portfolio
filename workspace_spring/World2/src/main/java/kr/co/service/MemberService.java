package kr.co.service;

import java.util.List;

import kr.co.domain.MemberDTO;

public interface MemberService {

	 void insert(MemberDTO dto) ;

	List<MemberDTO> list();

	MemberDTO read(String id);

	MemberDTO updateui(String id);

	void upate(MemberDTO dto);

	void delete(String id);
	
	

}
