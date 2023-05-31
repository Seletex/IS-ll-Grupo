package co.edu.uco.transformate.business.facade;

import java.util.List;

import co.edu.uco.transformate.dto.FacturaDTO;


public interface FacturaFacade {
void create(FacturaDTO dto);
	
	List <FacturaDTO> read(FacturaDTO dto);
	
	
	

}
