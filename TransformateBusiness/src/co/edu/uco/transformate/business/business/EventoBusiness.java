package co.edu.uco.transformate.business.business;

import java.util.List;

import co.edu.uco.transformate.business.domain.EventoDomain;


public interface EventoBusiness {
	
void create(EventoDomain domain);
	
	List <EventoDomain> read(EventoDomain domain);
	

	
	
}
