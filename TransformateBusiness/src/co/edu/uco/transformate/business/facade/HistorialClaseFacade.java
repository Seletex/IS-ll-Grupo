package co.edu.uco.transformate.business.facade;

import java.util.List;

import co.edu.uco.transformate.dto.HistorialClaseDTO;


public interface HistorialClaseFacade {
void create(HistorialClaseDTO dto);
	
	List <HistorialClaseDTO> read(HistorialClaseDTO dto);
	

}
