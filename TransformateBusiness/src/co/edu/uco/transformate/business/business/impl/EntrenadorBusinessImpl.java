package co.edu.uco.transformate.business.business.impl;

import java.util.List;

import co.edu.uco.transformate.business.assembler.concrete.EntrenadorAssembler;

import co.edu.uco.transformate.business.business.EntrenadorBusiness;
import co.edu.uco.transformate.business.domain.EntrenadorDomain;
import co.edu.uco.transformate.data.dao.factory.DAOFactory;
import co.edu.uco.transformate.entities.EntrenadorEntity;


public class EntrenadorBusinessImpl implements EntrenadorBusiness{

	private final DAOFactory daoFactory;

	public EntrenadorBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	
	@Override
	public void create(EntrenadorDomain domain) {
		final EntrenadorEntity entity = EntrenadorAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getEntrenadorDAO().create(entity);
		
	}

	@Override
	public List<EntrenadorDomain> read(EntrenadorDomain domain) {
		final EntrenadorEntity entity = EntrenadorAssembler.getInstance().toEntityFromDomain(domain);
		final List<EntrenadorEntity> resultEntities = daoFactory.getEntrenadorDAO().read(entity);
		return EntrenadorAssembler.getInstance().toDomainListFromEntityList(resultEntities);
	}

	@Override
	public void update(EntrenadorDomain domain) {
		final EntrenadorEntity entity = EntrenadorAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getEntrenadorDAO().update(entity);
		
	}

	@Override
	public void delete(EntrenadorDomain domain) {
		final EntrenadorEntity entity =
				EntrenadorAssembler
				.getInstance().toEntityFromDomain(domain);
		daoFactory.getEntrenadorDAO()
		.delete(entity);
		
	}

}
