package co.edu.uco.transformate.business.business.impl;

import java.util.List;

import co.edu.uco.transformate.business.assembler.concrete.ObjetivoEntrenamientoAssembler;

import co.edu.uco.transformate.business.business.ObjetivoEntrenamientoBusiness;
import co.edu.uco.transformate.business.domain.ObjetivoEntrenamientoDomain;
import co.edu.uco.transformate.data.dao.factory.DAOFactory;
import co.edu.uco.transformate.entities.ObjetivoEntrenamientoEntity;


public class ObjetivoEntrenamientoBusinessImpl implements ObjetivoEntrenamientoBusiness
{
	private final DAOFactory daoFactory ;
	
	public  ObjetivoEntrenamientoBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
		
	
	
	@Override
	public List<ObjetivoEntrenamientoDomain> read(ObjetivoEntrenamientoDomain domain) {
		final ObjetivoEntrenamientoEntity entity =
				ObjetivoEntrenamientoAssembler
				.getInstance().toEntityFromDomain(domain);
		final List<ObjetivoEntrenamientoEntity> resultEntities = daoFactory.
				getObjetivoEntrenamientoDAO().read(entity);
		return ObjetivoEntrenamientoAssembler.getInstance().
				toDomainListFromEntityList(resultEntities);
	}

}
