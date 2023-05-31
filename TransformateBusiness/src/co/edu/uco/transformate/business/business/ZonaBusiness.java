package co.edu.uco.transformate.business.business;

import java.util.List;

import co.edu.uco.transformate.business.domain.ZonaDomain;


public interface ZonaBusiness {
void create(ZonaDomain domain);
	
	List <ZonaDomain> read(ZonaDomain domain);
	
	void update(ZonaDomain domain);
	

}
