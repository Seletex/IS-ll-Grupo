package co.edu.uco.transformate.business.business;

import java.util.List;

import co.edu.uco.transformate.business.domain.EjercicioDomain;


public interface EjercicioBusiness {

void create(EjercicioDomain domain);
	
	List <EjercicioDomain> read(EjercicioDomain domain);
	
	void update(EjercicioDomain domain);
	
	void delete(EjercicioDomain domain);
}
