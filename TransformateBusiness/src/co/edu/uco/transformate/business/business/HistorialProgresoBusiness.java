package co.edu.uco.transformate.business.business;

import java.util.List;

import co.edu.uco.transformate.business.domain.HistorialProgresoDomain;


public interface HistorialProgresoBusiness {
void create(HistorialProgresoDomain domain);
	
	List <HistorialProgresoDomain> read(HistorialProgresoDomain domain);
	

}
