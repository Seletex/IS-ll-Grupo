package co.edu.uco.transformate.data.dao;

import java.util.List;


import co.edu.uco.transformate.entities.HistorialProgresoEntity;

public interface HistorialProgresoDAO {
void create(HistorialProgresoEntity entity);
	
	List <HistorialProgresoEntity> read(HistorialProgresoEntity entity);
	

}
