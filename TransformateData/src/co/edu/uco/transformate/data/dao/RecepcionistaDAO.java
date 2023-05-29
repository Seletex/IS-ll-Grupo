package co.edu.uco.transformate.data.dao;

import java.util.List;

import co.edu.uco.transformate.entities.RecepcionistaEntity;

public interface RecepcionistaDAO {
void create(RecepcionistaEntity entity);
	
	List <RecepcionistaEntity> read(RecepcionistaEntity entity);
	
	void update(RecepcionistaEntity entity);
	
	void delete(RecepcionistaEntity entity);
}
