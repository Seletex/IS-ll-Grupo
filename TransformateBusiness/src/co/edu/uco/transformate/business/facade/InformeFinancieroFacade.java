package co.edu.uco.transformate.business.facade;

import java.util.List;

import co.edu.uco.transformate.dto.InformeFinancieroDTO;


public interface InformeFinancieroFacade {
void create(InformeFinancieroDTO dto);
	
	List <InformeFinancieroDTO> read(InformeFinancieroDTO dto);
	
	
}
