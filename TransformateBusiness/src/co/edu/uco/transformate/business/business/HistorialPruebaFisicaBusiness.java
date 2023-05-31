package co.edu.uco.transformate.business.business;

import java.util.List;

import co.edu.uco.transformate.business.domain.HistorialPruebaFisicaDomain;


public interface HistorialPruebaFisicaBusiness {
void create(HistorialPruebaFisicaDomain domain);
	
	List <HistorialPruebaFisicaDomain> read(HistorialPruebaFisicaDomain domain);
	

}
