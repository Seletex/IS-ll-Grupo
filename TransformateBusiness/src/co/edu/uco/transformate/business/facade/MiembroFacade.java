package co.edu.uco.transformate.business.facade;

import java.util.List;

import co.edu.uco.transformate.dto.MiembroDTO;


public interface MiembroFacade {
void create(MiembroDTO dto);
	
	List <MiembroDTO> read(MiembroDTO dto);
	
	void update(MiembroDTO dto);
	

}
