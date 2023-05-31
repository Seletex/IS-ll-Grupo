package co.edu.uco.transformate.business.business;

import java.util.List;

import co.edu.uco.transformate.business.domain.EntrenadorDomain;


public interface EntrenadorBusiness {
	
void create(EntrenadorDomain domain);
	
	List <EntrenadorDomain> read(EntrenadorDomain domain);
	
	void update(EntrenadorDomain domain);
	
	void delete(EntrenadorDomain domain);

}
