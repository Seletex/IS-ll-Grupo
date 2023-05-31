package co.edu.uco.transformate.business.business;

import java.util.List;

import co.edu.uco.transformate.business.domain.HistorialNotaMedicaDomain;

public interface HistorialNotaMedicaBusiness {
void create(HistorialNotaMedicaDomain domain);
	
	List <HistorialNotaMedicaDomain> read(HistorialNotaMedicaDomain domain);
	

}
