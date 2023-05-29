package co.edu.uco.transformate.data.dao;

import java.util.List;


import co.edu.uco.transformate.entities.TipoPagoEntity;

public interface TipoPagoDAO {

	
	List <TipoPagoEntity> read(TipoPagoEntity entity);

}
