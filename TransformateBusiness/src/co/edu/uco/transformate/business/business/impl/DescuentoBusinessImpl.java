package co.edu.uco.transformate.business.business.impl;

import java.util.List;

import co.edu.uco.transformate.business.assembler.concrete.DescuentoAssembler;

import co.edu.uco.transformate.business.business.DescuentoBusiness;
import co.edu.uco.transformate.business.domain.DescuentoDomain;
import co.edu.uco.transformate.data.dao.factory.DAOFactory;
import co.edu.uco.transformate.entities.DescuentoEntity;


public class DescuentoBusinessImpl implements DescuentoBusiness{
	private final DAOFactory daoFactory;

	public DescuentoBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	@Override
	public void create(DescuentoDomain domain) {
		final DescuentoEntity entity = DescuentoAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getDescuentoDAO().create(entity);
		
	}

	@Override
	public List<DescuentoDomain> read(DescuentoDomain domain) {
		final DescuentoEntity entity = DescuentoAssembler.getInstance().toEntityFromDomain(domain);
		final List<DescuentoEntity> resultEntities = daoFactory.getDescuentoDAO().read(entity);
		return DescuentoAssembler.getInstance().toDomainListFromEntityList(resultEntities);
	}

	@Override
	public void delete(DescuentoDomain domain) {
		final DescuentoEntity entity =
				DescuentoAssembler
				.getInstance().toEntityFromDomain(domain);
		daoFactory.getDescuentoDAO()
		.delete(entity);
		
	}

}
