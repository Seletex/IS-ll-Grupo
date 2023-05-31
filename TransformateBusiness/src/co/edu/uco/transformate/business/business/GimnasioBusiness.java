package co.edu.uco.transformate.business.business;

import java.util.List;

import co.edu.uco.transformate.business.domain.GimnasioDomain;


public interface GimnasioBusiness {
void create(GimnasioDomain domain);
	
	List <GimnasioDomain> read(GimnasioDomain domain);
	
	void update(GimnasioDomain domain);
	

}
