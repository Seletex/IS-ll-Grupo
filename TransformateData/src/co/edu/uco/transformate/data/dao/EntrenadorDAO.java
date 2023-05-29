package co.edu.uco.transformate.data.dao;

import java.util.List;


import co.edu.uco.transformate.entities.EntrenadorEntity;

public interface EntrenadorDAO {
	
void create(EntrenadorEntity entity);
	
	List <EntrenadorEntity> read(EntrenadorEntity entity);
	
	void update(EntrenadorEntity entity);
	
	void delete(EntrenadorEntity entity);

}
