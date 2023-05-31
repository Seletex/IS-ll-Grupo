package co.edu.uco.transformate.business.facade;

import java.util.List;

import co.edu.uco.transformate.dto.TipoEgresoDTO;

public interface TipoEgresoFacade {

	
	List <TipoEgresoDTO> read(TipoEgresoDTO dto);

}
