package co.edu.uco.transformate.business.business.impl;

import java.util.List;


import co.edu.uco.transformate.business.assembler.concrete.TipoDescuentoAssembler;
import co.edu.uco.transformate.business.business.TipoDescuentoBusiness;
import co.edu.uco.transformate.business.domain.TipoDescuentoDomain;
import co.edu.uco.transformate.data.dao.factory.DAOFactory;

import co.edu.uco.transformate.entities.TipoDescuentoEntity;

public class TipoDescuentoBusinessImpl implements TipoDescuentoBusiness{

	private final DAOFactory daoFactory;

	public TipoDescuentoBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<TipoDescuentoDomain> read(TipoDescuentoDomain descuentoDomain) {
		final TipoDescuentoEntity entity = TipoDescuentoAssembler.getInstance().toEntityFromDomain(descuentoDomain);
		final List<TipoDescuentoEntity> resultEntities = daoFactory.geTipoDescuentoDAO().read(entity);
		return TipoDescuentoAssembler.getInstance().toDomainListFromEntityList(resultEntities);
	}

	
}
