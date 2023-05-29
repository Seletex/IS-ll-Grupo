package co.edu.uco.transformate.data.dao;

import java.util.List;


import co.edu.uco.transformate.entities.PlanEntrenamientoEntity;

public interface PlanEntrenamientoDAO {
void create(PlanEntrenamientoEntity entity);
	
	List <PlanEntrenamientoEntity> read(PlanEntrenamientoEntity entity);
	
	void update(PlanEntrenamientoEntity entity);
	

}
