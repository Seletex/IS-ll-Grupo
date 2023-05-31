package co.edu.uco.transformate.business.business;

import java.util.List;

import co.edu.uco.transformate.business.domain.EquipoDomain;


public interface EquipoBusiness {

void create(EquipoDomain domain);
	
	List <EquipoDomain> read(EquipoDomain domain);
	
	
	
	
}
