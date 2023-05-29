package co.edu.uco.transformate.data.dao;

import java.util.List;


import co.edu.uco.transformate.entities.HistorialClaseEntity;

public interface HistorialClaseDAO {
void create(HistorialClaseEntity entity);
	
	List <HistorialClaseEntity> read(HistorialClaseEntity entity);
	

}
