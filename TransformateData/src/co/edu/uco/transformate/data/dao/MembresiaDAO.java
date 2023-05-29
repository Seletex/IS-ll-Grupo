package co.edu.uco.transformate.data.dao;

import java.util.List;


import co.edu.uco.transformate.entities.MembresiaEntity;

public interface MembresiaDAO {
void create(MembresiaEntity entity);
	
	List <MembresiaEntity> read(MembresiaEntity entity);
	
	void update(MembresiaEntity entity);
	
	
}
