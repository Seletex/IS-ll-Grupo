package co.edu.uco.transformate.business.facade;

import java.util.List;

import co.edu.uco.transformate.dto.TipoMembresiaDTO;


public interface TipoMembresiaFacade {

	
	List <TipoMembresiaDTO> read(TipoMembresiaDTO dto);
	

}
