package co.edu.uco.transformate.business.business;

import java.util.List;

import co.edu.uco.transformate.business.domain.NotaMedicaDomain;


public interface NotaMedicaBusiness {
	void create(NotaMedicaDomain domain);

	List<NotaMedicaDomain> read(NotaMedicaDomain domain);

}
