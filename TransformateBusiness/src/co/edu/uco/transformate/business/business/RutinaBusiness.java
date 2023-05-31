package co.edu.uco.transformate.business.business;

import java.util.List;

import co.edu.uco.transformate.business.domain.RutinaDomain;


public interface RutinaBusiness {
void create(RutinaDomain domain);
	
	List <RutinaDomain> read(RutinaDomain domain);
	
	void update(RutinaDomain domain);
	

}
