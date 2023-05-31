package co.edu.uco.transformate.business.business;

import java.util.List;

import co.edu.uco.transformate.business.domain.ClaseDomain;


public interface ClaseBusiness {
	

	void create(ClaseDomain domain);
	
	List <ClaseDomain> read(ClaseDomain domain);
	
	void update(ClaseDomain domain);
	
	void delete(ClaseDomain domain);

}
