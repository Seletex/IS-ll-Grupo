package co.edu.uco.transformate.data.dao;

import java.util.List;


import co.edu.uco.transformate.entities.InformeFinancieroEntity;

public interface InformeFinancieroDAO {
void create(InformeFinancieroEntity entity);
	
	List <InformeFinancieroEntity> read(InformeFinancieroEntity entity);
	
	
}
