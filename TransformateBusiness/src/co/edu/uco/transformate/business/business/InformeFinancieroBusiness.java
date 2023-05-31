package co.edu.uco.transformate.business.business;

import java.util.List;

import co.edu.uco.transformate.business.domain.InformeFinancieroDomain;

public interface InformeFinancieroBusiness {
void create(InformeFinancieroDomain domain);
	
	List <InformeFinancieroDomain> read(InformeFinancieroDomain domain);
	
	
}
