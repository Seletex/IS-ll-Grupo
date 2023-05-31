package co.edu.uco.transformate.business.business;

import java.util.List;

import co.edu.uco.transformate.business.domain.PlanEntrenamientoDomain;


public interface PlanEntrenamientoBusiness {
void create(PlanEntrenamientoDomain domain);
	
	List <PlanEntrenamientoDomain> read(PlanEntrenamientoDomain domain);
	
	void update(PlanEntrenamientoDomain domain);
	

}
