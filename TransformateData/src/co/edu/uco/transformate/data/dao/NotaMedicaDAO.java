package co.edu.uco.transformate.data.dao;

import java.util.List;

import co.edu.uco.transformate.entities.NotaMedicaEntity;

public interface NotaMedicaDAO {
	void create(NotaMedicaEntity entity);

	List<NotaMedicaEntity> read(NotaMedicaEntity entity);

}
