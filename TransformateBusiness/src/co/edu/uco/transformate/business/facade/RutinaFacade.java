package co.edu.uco.transformate.business.facade;

import java.util.List;

import co.edu.uco.transformate.dto.RutinaDTO;


public interface RutinaFacade {
void create(RutinaDTO dto);
	
	List <RutinaDTO> read(RutinaDTO dto);
	
	void update(RutinaDTO dto);
	

}
