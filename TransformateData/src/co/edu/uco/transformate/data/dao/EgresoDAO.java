package co.edu.uco.transformate.data.dao;

import java.util.List;


import co.edu.uco.transformate.entities.EgresoEntity;

public interface EgresoDAO {
	
void create(EgresoEntity entity);
	
	List <EgresoEntity> read(EgresoEntity entity);
	

}
