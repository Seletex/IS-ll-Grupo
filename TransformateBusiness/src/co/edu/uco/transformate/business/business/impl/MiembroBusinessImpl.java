package co.edu.uco.transformate.business.business.impl;


import java.util.List;


import co.edu.uco.transformate.business.assembler.concrete.MiembroAssembler;
import co.edu.uco.transformate.business.business.MiembroBusiness;
import co.edu.uco.transformate.business.domain.MiembroDomain;
import co.edu.uco.transformate.data.dao.factory.DAOFactory;

import co.edu.uco.transformate.entities.MiembroEntity;



public class MiembroBusinessImpl implements MiembroBusiness{

	private final DAOFactory daoFactory;

	public MiembroBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	@Override
	public void create(MiembroDomain domain) {
		final MiembroEntity entity = MiembroAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getMiembroDAO().create(entity);
		
	}

	@Override
	public List<MiembroDomain> read(MiembroDomain domain) {
		final MiembroEntity entity = MiembroAssembler.getInstance().toEntityFromDomain(domain);
		final List<MiembroEntity> resultEntities = daoFactory.getMiembroDAO().read(entity);
		return MiembroAssembler.getInstance().toDomainListFromEntityList(resultEntities);
	}

	@Override
	public void update(MiembroDomain domain) {
		final MiembroEntity entity = MiembroAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getMiembroDAO().update(entity);
		
	}

}