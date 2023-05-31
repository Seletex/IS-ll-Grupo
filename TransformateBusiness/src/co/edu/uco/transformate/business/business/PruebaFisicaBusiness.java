package co.edu.uco.transformate.business.business;

import java.util.List;

import co.edu.uco.transformate.business.domain.PruebaFisicaDomain;


public interface PruebaFisicaBusiness {
void create(PruebaFisicaDomain domain);
	
	List <PruebaFisicaDomain> read(PruebaFisicaDomain domain);
	
	
}
