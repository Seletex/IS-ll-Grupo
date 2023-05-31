package co.edu.uco.transformate.business.business;

import java.util.List;

import co.edu.uco.transformate.business.domain.GerenteDomain;


public interface GerenteBusiness {
void create(GerenteDomain domain);
	
	List <GerenteDomain> read(GerenteDomain domain);
	
	void update(GerenteDomain domain);
	
	
}
