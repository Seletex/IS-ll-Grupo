package co.edu.uco.transformate.data.dao;

import java.util.List;


import co.edu.uco.transformate.entities.HistorialPruebaFisicaEntity;

public interface HistorialPruebaFisicaDAO {
void create(HistorialPruebaFisicaEntity entity);
	
	List <HistorialPruebaFisicaEntity> read(HistorialPruebaFisicaEntity entity);
	

}
