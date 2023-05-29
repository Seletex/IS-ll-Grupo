package co.edu.uco.transformate.data.dao;

import java.util.List;


import co.edu.uco.transformate.entities.ProgresoEntity;

public interface ProgresoDAO {
void create(ProgresoEntity entity);
	
	List <ProgresoEntity> read(ProgresoEntity entity);
	

}
