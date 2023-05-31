package co.edu.uco.transformate.business.facade;

import java.util.List;

import co.edu.uco.transformate.dto.NotaMedicaDTO;


public interface NotaMedicaFacade {
	void create(NotaMedicaDTO dto);

	List<NotaMedicaDTO> read(NotaMedicaDTO dto);

}
