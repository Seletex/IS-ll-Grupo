package co.edu.uco.transformate.business.facade;

import java.util.List;

import co.edu.uco.transformate.dto.ZonaDTO;


public interface ZonaFacade {
void create(ZonaDTO dto);
	
	List <ZonaDTO> read(ZonaDTO dto);
	
	void update(ZonaDTO dto);
	

}
