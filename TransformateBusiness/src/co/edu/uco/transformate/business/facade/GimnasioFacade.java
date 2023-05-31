package co.edu.uco.transformate.business.facade;

import java.util.List;

import co.edu.uco.transformate.dto.GimnasioDTO;


public interface GimnasioFacade {
void create(GimnasioDTO dto);
	
	List <GimnasioDTO> read(GimnasioDTO dto);
	
	void update(GimnasioDTO dto);
	

}
