package kr.co.persistence;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.domain.DepartDTO;
@Repository
public interface DepartDAO {

	void insert(DepartDTO dto);

	List<DepartDTO> list();

	DepartDTO read(String did);

	DepartDTO updateui(String did);

	void update(DepartDTO dto);

	void delete(String did);

}
