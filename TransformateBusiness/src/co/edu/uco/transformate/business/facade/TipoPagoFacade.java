package co.edu.uco.transformate.business.facade;

import java.util.List;

import co.edu.uco.transformate.dto.TipoPagoDTO;

public interface TipoPagoFacade {

	
	List <TipoPagoDTO> read(TipoPagoDTO dto);

}
