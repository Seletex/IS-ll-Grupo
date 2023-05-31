package co.edu.uco.transformate.business.facade;

import java.util.List;

import co.edu.uco.transformate.dto.ProgresoDTO;


public interface ProgresoFacade {
void create(ProgresoDTO dto);
	
	List <ProgresoDTO> read(ProgresoDTO dto);
	

}
