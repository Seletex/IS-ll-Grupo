package co.edu.uco.transformate.data.dao;

import java.util.List;


import co.edu.uco.transformate.entities.EquipoEntity;

public interface EquipoDAO {

void create(EquipoEntity entity);
	
	List <EquipoEntity> read(EquipoEntity entity);
	
	
	
	
}
