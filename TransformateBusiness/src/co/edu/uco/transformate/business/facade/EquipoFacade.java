package co.edu.uco.transformate.business.facade;

import java.util.List;

import co.edu.uco.transformate.dto.EquipoDTO;

public interface EquipoFacade {

void create(EquipoDTO dto);
	
	List <EquipoDTO> read(EquipoDTO dto);
	
	
	
	
}
