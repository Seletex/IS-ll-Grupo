package co.edu.uco.transformate.business.business.impl;

import java.util.List;


import co.edu.uco.transformate.business.assembler.concrete.GimnasioAssembler;

import co.edu.uco.transformate.business.business.GimnasioBusiness;
import co.edu.uco.transformate.business.domain.GimnasioDomain;
import co.edu.uco.transformate.data.dao.factory.DAOFactory;
import co.edu.uco.transformate.entities.GimnasioEntity;


public class GimnasioBusinessImpl implements GimnasioBusiness {

	private final DAOFactory daoFactory;

	public GimnasioBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void create(GimnasioDomain domain) {
		final GimnasioEntity entity = GimnasioAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getGimnasioDAO().create(entity);

	}

	@Override
	public List<GimnasioDomain> read(GimnasioDomain domain) {
		final GimnasioEntity entity = GimnasioAssembler.getInstance().toEntityFromDomain(domain);
		final List<GimnasioEntity> resultEntities = daoFactory.getGimnasioDAO().read(entity);
		return GimnasioAssembler.getInstance().toDomainListFromEntityList(resultEntities);
	}

	@Override
	public void update(GimnasioDomain domain) {
		
		final GimnasioEntity entity = GimnasioAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getGimnasioDAO().update(entity);
		
		

	}

}
