package co.edu.uco.transformate.business.business;

import java.util.List;


import co.edu.uco.transformate.business.domain.TipoMiembroDomain;


public interface TipoMiembroBusiness {

	
	List <TipoMiembroDomain> read(TipoMiembroDomain domain);
	

}
