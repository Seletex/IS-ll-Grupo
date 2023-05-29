package co.edu.uco.transformate.data.dao;

import java.util.List;


import co.edu.uco.transformate.entities.ClaseEntity;

public interface ClaseDAO {
	

	void create(ClaseEntity entity);
	
	List <ClaseEntity> read(ClaseEntity entity);
	
	void update(ClaseEntity entity);
	
	void delete(ClaseEntity entity);

}
