package co.edu.uco.transformate.business.business;

import java.util.List;

import co.edu.uco.transformate.business.domain.ProductoDomain;


public interface ProductoBusiness {
void create(ProductoDomain domain);
	
	List <ProductoDomain> read(ProductoDomain domain);
	
	void update(ProductoDomain domain);
	
	
}
