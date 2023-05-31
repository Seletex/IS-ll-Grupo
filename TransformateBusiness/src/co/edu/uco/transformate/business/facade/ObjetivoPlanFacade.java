package co.edu.uco.transformate.business.facade;

import java.util.List;

import co.edu.uco.transformate.dto.ObjetivoPlanDTO;




public interface ObjetivoPlanFacade {
void create(ObjetivoPlanDTO dto);
	
	List <ObjetivoPlanDTO> read(ObjetivoPlanDTO dto);
	
	void update(ObjetivoPlanDTO dto);

}
