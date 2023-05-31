package co.edu.uco.transformate.business.business;

import java.util.List;

import co.edu.uco.transformate.business.domain.MiembroDomain;

public interface MiembroBusiness {
void create(MiembroDomain domain);
	
	List <MiembroDomain> read(MiembroDomain domain);
	
	void update(MiembroDomain domain);
	

}
