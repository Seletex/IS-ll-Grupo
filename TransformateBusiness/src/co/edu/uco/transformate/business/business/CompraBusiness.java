package co.edu.uco.transformate.business.business;

import java.util.List;

import co.edu.uco.transformate.business.domain.CompraDomain;


public interface CompraBusiness {

void create(CompraDomain domain);
	
	List <CompraDomain> read(CompraDomain domain);
	
}
