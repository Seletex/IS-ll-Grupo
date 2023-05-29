package co.edu.uco.transformate.data.dao;

import java.util.List;


import co.edu.uco.transformate.entities.ZonaEntity;

public interface ZonaDAO {
void create(ZonaEntity entity);
	
	List <ZonaEntity> read(ZonaEntity entity);
	
	void update(ZonaEntity entity);
	

}
