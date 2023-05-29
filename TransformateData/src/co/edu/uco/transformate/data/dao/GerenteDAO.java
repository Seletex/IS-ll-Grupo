package co.edu.uco.transformate.data.dao;

import java.util.List;


import co.edu.uco.transformate.entities.GerenteEntity;

public interface GerenteDAO {
void create(GerenteEntity entity);
	
	List <GerenteEntity> read(GerenteEntity entity);
	
	void update(GerenteEntity entity);
	
	
}
