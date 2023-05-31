package co.edu.uco.transformate.business.facade;

import java.util.List;

import co.edu.uco.transformate.dto.HistorialProgresoDTO;


public interface HistorialProgresoFacade {
void create(HistorialProgresoDTO dto);
	
	List <HistorialProgresoDTO> read(HistorialProgresoDTO dto);
	

}
