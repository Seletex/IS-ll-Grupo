package co.edu.uco.transformate.business.business.impl;

import java.util.List;

import co.edu.uco.transformate.business.assembler.concrete.TipoDocumentoAssembler;
import co.edu.uco.transformate.business.business.TipoDocumentoBusiness;
import co.edu.uco.transformate.business.domain.TipoDocumentoDomain;
import co.edu.uco.transformate.data.dao.factory.DAOFactory;
import co.edu.uco.transformate.entities.TipoDocumentoEntity;

public class TipoDocumentoBusinessImpl implements TipoDocumentoBusiness{


	private final  DAOFactory daoFactory;

	public TipoDocumentoBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	
	@Override
	public List<TipoDocumentoDomain> read(TipoDocumentoDomain domain) {
		final TipoDocumentoEntity entity =
				TipoDocumentoAssembler
				.getInstance().toEntityFromDomain(domain);
		final List<TipoDocumentoEntity> resultEntities = daoFactory.
				geTipoDocumentoDAO().read(entity);
		return TipoDocumentoAssembler.getInstance().
				toDomainListFromEntityList(resultEntities);
	}

}
