package co.edu.uco.transformate.business.business;

import java.util.List;

import co.edu.uco.transformate.business.domain.EgresoDomain;


public interface EgresoBusiness {
	
void create(EgresoDomain domain);
	
	List <EgresoDomain> read(EgresoDomain domain);
	

}
