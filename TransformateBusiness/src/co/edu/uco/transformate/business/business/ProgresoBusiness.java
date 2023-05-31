package co.edu.uco.transformate.business.business;

import java.util.List;

import co.edu.uco.transformate.business.domain.ProgresoDomain;


public interface ProgresoBusiness {
void create(ProgresoDomain domain);
	
	List <ProgresoDomain> read(ProgresoDomain domain);
	

}
