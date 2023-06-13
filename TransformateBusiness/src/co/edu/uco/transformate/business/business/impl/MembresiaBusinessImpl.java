package co.edu.uco.transformate.business.business.impl;

import java.util.List;


import co.edu.uco.transformate.business.assembler.concrete.MembresiaAssembler;
import co.edu.uco.transformate.business.business.MembresiaBusiness;
import co.edu.uco.transformate.business.domain.MembresiaDomain;


import co.edu.uco.transformate.data.dao.factory.DAOFactory;

import co.edu.uco.transformate.entities.MembresiaEntity;

public class MembresiaBusinessImpl implements MembresiaBusiness{
	private final DAOFactory daoFactory;

	public MembresiaBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	@Override
	public List<MembresiaDomain> read(MembresiaDomain domain) {
		final MembresiaEntity entity = MembresiaAssembler.getInstance().toEntityFromDomain(domain);
		final List<MembresiaEntity> resultEntities = daoFactory.getMembresiaDAO().read(entity);
		return MembresiaAssembler.getInstance().toDomainListFromEntityList(resultEntities);
	}
	

}
