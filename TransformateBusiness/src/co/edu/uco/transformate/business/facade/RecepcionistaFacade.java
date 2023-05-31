package co.edu.uco.transformate.business.facade;

import java.util.List;

import co.edu.uco.transformate.dto.RecepcionistaDTO;


public interface RecepcionistaFacade {
void create(RecepcionistaDTO dto);
	
	List <RecepcionistaDTO> read(RecepcionistaDTO dto);
	
	void update(RecepcionistaDTO dto);
	
	void delete(RecepcionistaDTO dto);
}
