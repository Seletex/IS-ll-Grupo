package co.edu.uco.transformate.data.dao;

import java.util.List;


import co.edu.uco.transformate.entities.EstadoPagoEntity;

public interface EstadoPagoDAO {


	
	List <EstadoPagoEntity> read(EstadoPagoEntity entity);
	

}
