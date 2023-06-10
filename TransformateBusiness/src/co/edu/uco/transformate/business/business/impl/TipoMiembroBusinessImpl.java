package co.edu.uco.transformate.business.business.impl;

import java.util.List;

import co.edu.uco.transformate.business.assembler.concrete.TipoMiembroAssembler;
import co.edu.uco.transformate.business.business.TipoMiembroBusiness;
import co.edu.uco.transformate.business.domain.TipoMiembroDomain;
import co.edu.uco.transformate.data.dao.factory.DAOFactory;
import co.edu.uco.transformate.entities.TipoMiembroEntity;

public class TipoMiembroBusinessImpl implements TipoMiembroBusiness{


	private final  DAOFactory daoFactory;

	public TipoMiembroBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	
	@Override
	public List<TipoMiembroDomain> read(TipoMiembroDomain domain) {
		final TipoMiembroEntity entity =
				TipoMiembroAssembler
				.getInstance().toEntityFromDomain(domain);
		final List<TipoMiembroEntity> resultEntities = daoFactory.
				geTipoMiembroDAO().read(entity);
		return TipoMiembroAssembler.getInstance().
				toDomainListFromEntityList(resultEntities);
	}
}
