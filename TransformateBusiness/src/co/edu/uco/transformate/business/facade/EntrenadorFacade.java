package co.edu.uco.transformate.business.facade;

import java.util.List;

import co.edu.uco.transformate.dto.EntrenadorDTO;


public interface EntrenadorFacade {
	
void create(EntrenadorDTO dto);
	
	List <EntrenadorDTO> read(EntrenadorDTO dto);
	
	void update(EntrenadorDTO dto);
	
	void delete(EntrenadorDTO dto);

}
