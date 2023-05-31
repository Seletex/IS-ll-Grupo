package co.edu.uco.transformate.business.facade;

import java.util.List;

import co.edu.uco.transformate.dto.TipoDocumentoDTO;


public interface TipoDocumentoFacade {

	
	List <TipoDocumentoDTO> read(TipoDocumentoDTO dto);
	

}
