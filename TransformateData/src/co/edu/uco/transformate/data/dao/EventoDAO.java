package co.edu.uco.transformate.data.dao;

import java.util.List;


import co.edu.uco.transformate.entities.EventoEntity;

public interface EventoDAO {
void create(EventoEntity entity);
	
	List <EventoEntity> read(EventoEntity entity);
	

	
	
}
