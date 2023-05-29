package co.edu.uco.transformate.data.dao;

import java.util.List;


import co.edu.uco.transformate.entities.HistorialNotaMedicaEntity;

public interface HistorialNotaMedicaDAO {
void create(HistorialNotaMedicaEntity entity);
	
	List <HistorialNotaMedicaEntity> read(HistorialNotaMedicaEntity entity);
	

}
