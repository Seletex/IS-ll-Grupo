package co.edu.uco.transformate.business.business.impl;

import java.util.List;

import co.edu.uco.transformate.business.assembler.concrete.TipoMembresiaAssembler;
import co.edu.uco.transformate.business.business.TipoMembresiaBusiness;
import co.edu.uco.transformate.business.domain.TipoMembresiaDomain;
import co.edu.uco.transformate.data.dao.factory.DAOFactory;
import co.edu.uco.transformate.entities.TipoMembresiaEntity;



public class TipoMembresiaBusinessImpl implements TipoMembresiaBusiness{
	private final DAOFactory daoFactory;

	public TipoMembresiaBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	@Override
	public List<TipoMembresiaDomain> read(TipoMembresiaDomain domain) {
		final TipoMembresiaEntity entity = TipoMembresiaAssembler.getInstance().toEntityFromDomain(domain);
		final List<TipoMembresiaEntity> resultEntities = daoFactory.geTipoMembresiaDAO().read(entity);
		return TipoMembresiaAssembler.getInstance().toDomainListFromEntityList(resultEntities);
	}
	

}
