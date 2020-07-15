package kr.co.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.domain.DepartDTO;
import kr.co.persistence.DepartDAO;

@Service
@Transactional
public class DepartServiceImpl implements DepartService {
	@Autowired
	private DepartDAO dDAO;

	@Override
	public void insert(DepartDTO dto) {
		dDAO.insert(dto);
	}

	@Override
	public List<DepartDTO> list() {

		return dDAO.list();
	}

	@Override
	public DepartDTO read(String did) {
		// TODO Auto-generated method stub
		return dDAO.read(did);
	}

	@Override
	public DepartDTO updateui(String did) {
		// TODO Auto-generated method stub
		return dDAO.updateui(did);
	}

	@Override
	public void update(DepartDTO dto) {
		dDAO.update(dto);

	}

	@Override
	public void delete(String did) {
		dDAO.delete(did);
		
	}

}
