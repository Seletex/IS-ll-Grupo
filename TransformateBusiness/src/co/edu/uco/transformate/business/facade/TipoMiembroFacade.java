package co.edu.uco.transformate.business.facade;

import java.util.List;

import co.edu.uco.transformate.dto.TipoMiembroDTO;


public interface TipoMiembroFacade {

	
	List <TipoMiembroDTO> read(TipoMiembroDTO dto);
	

}
