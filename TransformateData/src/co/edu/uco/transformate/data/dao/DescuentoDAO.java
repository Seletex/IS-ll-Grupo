package co.edu.uco.transformate.data.dao;

import java.util.List;


import co.edu.uco.transformate.entities.DescuentoEntity;

public interface DescuentoDAO {

	void create(DescuentoEntity entity);

	List<DescuentoEntity> read(DescuentoEntity entity);

	void delete(DescuentoEntity entity);
}
