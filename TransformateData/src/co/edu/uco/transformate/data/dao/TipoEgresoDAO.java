package co.edu.uco.transformate.data.dao;

import java.util.List;


import co.edu.uco.transformate.entities.TipoEgresoEntity;

public interface TipoEgresoDAO {

	
	List <TipoEgresoEntity> read(TipoEgresoEntity entity);

}
