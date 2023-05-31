package co.edu.uco.transformate.business.business;

import java.util.List;

import co.edu.uco.transformate.business.domain.FacturaDomain;


public interface FacturaBusiness {
void create(FacturaDomain domain);
	
	List <FacturaDomain> read(FacturaDomain domain);
	
	
	

}
