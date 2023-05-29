package co.edu.uco.transformate.data.dao;

import java.util.List;
import co.edu.uco.transformate.entities.OjetivoPlanEntity;



public interface ObjetivoPlanDAO {
void create(OjetivoPlanEntity entity);
	
	List <OjetivoPlanEntity> read(OjetivoPlanEntity entity);
	
	void update(OjetivoPlanEntity entity);

}
