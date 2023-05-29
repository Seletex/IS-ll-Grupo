package co.edu.uco.transformate.data.dao;

import java.util.List;


import co.edu.uco.transformate.entities.TipoDocumentoEntity;

public interface TipoDocumentoDAO {

	
	List <TipoDocumentoEntity> read(TipoDocumentoEntity entity);
	

}
