package co.edu.uco.transformate.business.business;

import java.util.List;

import co.edu.uco.transformate.business.domain.TipoDocumentoDomain;


public interface TipoDocumentoBusiness {

	
	List <TipoDocumentoDomain> read(TipoDocumentoDomain domain);
	

}
