package co.edu.uco.transformate.business.facade;

import java.util.List;

import co.edu.uco.transformate.dto.CompraDTO;
import co.edu.uco.transformate.entities.CompraEntity;

public interface CompraFacade {

void create(CompraEntity entity);
	
	List <CompraDTO> read(CompraDTO dto);
	
}
