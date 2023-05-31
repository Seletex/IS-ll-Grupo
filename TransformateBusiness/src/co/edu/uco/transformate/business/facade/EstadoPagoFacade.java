package co.edu.uco.transformate.business.facade;

import java.util.List;

import co.edu.uco.transformate.dto.EstadoPagoDTO;


public interface EstadoPagoFacade {


	
	List <EstadoPagoDTO> read(EstadoPagoDTO dto);
	

}
