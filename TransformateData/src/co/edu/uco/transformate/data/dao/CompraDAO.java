package co.edu.uco.transformate.data.dao;

import java.util.List;


import co.edu.uco.transformate.entities.CompraEntity;

public interface CompraDAO {

void create(CompraEntity entity);
	
	List <CompraEntity> read(CompraEntity entity);
	
}
