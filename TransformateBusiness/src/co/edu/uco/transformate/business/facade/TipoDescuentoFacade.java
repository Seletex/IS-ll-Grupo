package co.edu.uco.transformate.business.facade;

import java.util.List;

import co.edu.uco.transformate.dto.TipoDescuentoDTO;



public interface TipoDescuentoFacade {

	
	List <TipoDescuentoDTO> read(TipoDescuentoDTO dto);
	

}
