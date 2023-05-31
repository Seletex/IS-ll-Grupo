package co.edu.uco.transformate.business.facade;

import java.util.List;

import co.edu.uco.transformate.dto.ClaseDTO;


public interface ClaseFacade {
	

	void create(ClaseDTO dto);
	
	List <ClaseDTO> read(ClaseDTO dto);
	
	void update(ClaseDTO dto);
	
	void delete(ClaseDTO dto);

}
