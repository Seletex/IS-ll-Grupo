package co.edu.uco.transformate.business.business;

import java.util.List;

import co.edu.uco.transformate.business.domain.HistorialClaseDomain;


public interface HistorialClaseBusiness {
void create(HistorialClaseDomain domain);
	
	List <HistorialClaseDomain> read(HistorialClaseDomain domain);
	

}
