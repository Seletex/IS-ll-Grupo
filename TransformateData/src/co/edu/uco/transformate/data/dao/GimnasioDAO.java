package co.edu.uco.transformate.data.dao;

import java.util.List;


import co.edu.uco.transformate.entities.GimnasioEntity;

public interface GimnasioDAO {
void create(GimnasioEntity entity);
	
	List <GimnasioEntity> read(GimnasioEntity entity);
	
	void update(GimnasioEntity entity);
	

}
