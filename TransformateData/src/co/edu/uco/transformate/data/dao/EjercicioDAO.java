package co.edu.uco.transformate.data.dao;

import java.util.List;


import co.edu.uco.transformate.entities.EjercicioEntity;

public interface EjercicioDAO {

void create(EjercicioEntity entity);
	
	List <EjercicioEntity> read(EjercicioEntity entity);
	
	void update(EjercicioEntity entity);
	
	void delete(EjercicioEntity entity);
}
