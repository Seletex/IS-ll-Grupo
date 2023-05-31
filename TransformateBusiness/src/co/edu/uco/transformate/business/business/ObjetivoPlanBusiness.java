package co.edu.uco.transformate.business.business;

import java.util.List;

import co.edu.uco.transformate.business.domain.ObjetivoPlanDomain;




public interface ObjetivoPlanBusiness {
void create(ObjetivoPlanDomain domain);
	
	List <ObjetivoPlanDomain> read(ObjetivoPlanDomain domain);
	
	void update(ObjetivoPlanDomain domain);

}
