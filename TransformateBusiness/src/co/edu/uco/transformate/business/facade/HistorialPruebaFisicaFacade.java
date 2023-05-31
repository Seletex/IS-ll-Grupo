package co.edu.uco.transformate.business.facade;

import java.util.List;

import co.edu.uco.transformate.dto.HistorialPruebaFisicaDTO;


public interface HistorialPruebaFisicaFacade {
void create(HistorialPruebaFisicaDTO dto);
	
	List <HistorialPruebaFisicaDTO> read(HistorialPruebaFisicaDTO dto);
	

}
