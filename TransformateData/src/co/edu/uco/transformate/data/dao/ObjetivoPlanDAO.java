package co.edu.uco.transformate.data.dao;

import java.util.List;
import co.edu.uco.transformate.entities.ObjetivoPlanEntity;



public interface ObjetivoPlanDAO {
void create(ObjetivoPlanEntity entity);
	
	List <ObjetivoPlanEntity> read(ObjetivoPlanEntity entity);
	
	void update(ObjetivoPlanEntity entity);

}
