package co.edu.uco.transformate.business.facade;

import java.util.List;

import co.edu.uco.transformate.dto.HistorialNotaMedicaDTO;


public interface HistorialNotaMedicaFacade {
void create(HistorialNotaMedicaDTO dto);
	
	List <HistorialNotaMedicaDTO> read(HistorialNotaMedicaDTO dto);
	

}
