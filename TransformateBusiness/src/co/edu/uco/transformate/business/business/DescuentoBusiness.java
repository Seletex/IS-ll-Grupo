package co.edu.uco.transformate.business.business;

import java.util.List;

import co.edu.uco.transformate.business.domain.DescuentoDomain;


public interface DescuentoBusiness {

	void create(DescuentoDomain domain);

	List<DescuentoDomain> read(DescuentoDomain domain);

	void delete(DescuentoDomain domain);
}
