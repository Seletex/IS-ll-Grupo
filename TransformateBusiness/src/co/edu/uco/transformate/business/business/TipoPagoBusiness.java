package co.edu.uco.transformate.business.business;

import java.util.List;

import co.edu.uco.transformate.business.domain.TipoPagoDomain;


public interface TipoPagoBusiness {

	
	List <TipoPagoDomain> read(TipoPagoDomain domain);

}
