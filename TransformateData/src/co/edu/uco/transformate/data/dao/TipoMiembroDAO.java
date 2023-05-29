package co.edu.uco.transformate.data.dao;

import java.util.List;


import co.edu.uco.transformate.entities.TipoMiembroEntity;

public interface TipoMiembroDAO {

	
	List <TipoMiembroEntity> read(TipoMiembroEntity entity);
	

}
