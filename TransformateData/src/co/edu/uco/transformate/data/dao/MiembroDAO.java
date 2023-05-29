package co.edu.uco.transformate.data.dao;

import java.util.List;

import co.edu.uco.transformate.entities.MiembroEntity;

public interface MiembroDAO {
void create(MiembroEntity entity);
	
	List <MiembroEntity> read(MiembroEntity entity);
	
	void update(MiembroEntity entity);
	

}
