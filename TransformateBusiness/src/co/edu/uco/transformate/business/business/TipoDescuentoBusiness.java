package co.edu.uco.transformate.business.business;

import java.util.List;

import co.edu.uco.transformate.business.domain.TipoDescuentoDomain;



public interface TipoDescuentoBusiness {

	
	List <TipoDescuentoDomain> read(TipoDescuentoDomain descuentoDomain);
	

}
