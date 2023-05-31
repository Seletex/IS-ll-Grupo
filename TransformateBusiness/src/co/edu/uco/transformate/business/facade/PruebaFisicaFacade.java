package co.edu.uco.transformate.business.facade;

import java.util.List;

import co.edu.uco.transformate.dto.PruebaFisicaDTO;


public interface PruebaFisicaFacade {
void create(PruebaFisicaDTO dto);
	
	List <PruebaFisicaDTO> read(PruebaFisicaDTO dto);
	
	
}
