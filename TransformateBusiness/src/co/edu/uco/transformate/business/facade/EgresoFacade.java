package co.edu.uco.transformate.business.facade;

import java.util.List;

import co.edu.uco.transformate.dto.EgresoDTO;


public interface EgresoFacade {
	
void create(EgresoDTO dto);
	
	List <EgresoDTO> read(EgresoDTO dto);
	

}
