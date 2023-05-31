package co.edu.uco.transformate.business.business;

import java.util.List;

import co.edu.uco.transformate.business.domain.RecepcionistaDomain;


public interface RecepcionistaBusiness {
	
void create(RecepcionistaDomain domain);
	
	List <RecepcionistaDomain> read(RecepcionistaDomain domain);
	
	void update(RecepcionistaDomain domain);
	
	void delete(RecepcionistaDomain domain);
}
