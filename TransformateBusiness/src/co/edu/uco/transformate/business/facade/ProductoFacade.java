package co.edu.uco.transformate.business.facade;

import java.util.List;

import co.edu.uco.transformate.dto.ProductoDTO;


public interface ProductoFacade {
void create(ProductoDTO dto);
	
	List <ProductoDTO> read(ProductoDTO dto);
	
	void update(ProductoDTO dto);
	
	
}
