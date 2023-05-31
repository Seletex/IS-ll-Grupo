package co.edu.uco.transformate.business.facade;

import java.util.List;

import co.edu.uco.transformate.dto.EjercicioDTO;

public interface EjercicioFacade {

void create(EjercicioDTO dto);
	
	List <EjercicioDTO> read(EjercicioDTO dto);
	
	void update(EjercicioDTO dto);
	
	void delete(EjercicioDTO dto);
}
