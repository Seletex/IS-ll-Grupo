package co.edu.uco.transformate.data.dao;

import java.util.List;


import co.edu.uco.transformate.entities.FacturaEntity;

public interface FacturaDAO {
void create(FacturaEntity entity);
	
	List <FacturaEntity> read(FacturaEntity entity);
	
	
	
	void delete(FacturaEntity entity);
}
