package co.edu.uco.transformate.data.dao;

import java.util.List;


import co.edu.uco.transformate.entities.PruebaFisicaEntity;

public interface PruebaFisicaDAO {
void create(PruebaFisicaEntity entity);
	
	List <PruebaFisicaEntity> read(PruebaFisicaEntity entity);
	
	
}
