package co.edu.uco.transformate.business.facade;

import java.util.List;

import co.edu.uco.transformate.dto.PlanEntrenamientoDTO;


public interface PlanEntrenamientoFacade {
void create(PlanEntrenamientoDTO dto);
	
	List <PlanEntrenamientoDTO> read(PlanEntrenamientoDTO dto);
	
	void update(PlanEntrenamientoDTO dto);
	

}
