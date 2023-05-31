package co.edu.uco.transformate.business.facade;

import java.util.List;

import co.edu.uco.transformate.dto.EventoDTO;


public interface EventoFacade {
void create(EventoDTO dto);
	
	List <EventoDTO> read(EventoDTO dto);
	

	
	
}
