package co.edu.uco.transformate.business.facade;

import java.util.List;

import co.edu.uco.transformate.dto.DescuentoDTO;


public interface DescuentoFacade {

	void create(DescuentoDTO dto);

	List<DescuentoDTO> read(DescuentoDTO dto);

	void delete(DescuentoDTO dto);
}
