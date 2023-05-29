package co.edu.uco.transformate.data.dao;

import java.util.List;

import co.edu.uco.transformate.entities.RutinaEntity;

public interface RutinaDAO {
void create(RutinaEntity entity);
	
	List <RutinaEntity> read(RutinaEntity entity);
	
	void update(RutinaEntity entity);
	

}
