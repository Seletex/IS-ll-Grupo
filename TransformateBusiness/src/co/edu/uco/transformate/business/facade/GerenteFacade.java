package co.edu.uco.transformate.business.facade;

import java.util.List;

import co.edu.uco.transformate.dto.GerenteDTO;


public interface GerenteFacade {
void create(GerenteDTO dto);
	
	List <GerenteDTO> read(GerenteDTO dto);
	
	void update(GerenteDTO dto);
	
	
}
