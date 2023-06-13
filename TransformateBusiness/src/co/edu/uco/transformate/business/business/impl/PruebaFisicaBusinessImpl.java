package co.edu.uco.transformate.business.business.impl;

import java.util.List;

import co.edu.uco.transformate.business.assembler.concrete.PruebaFisicaAssembler;
import co.edu.uco.transformate.business.business.PruebaFisicaBusiness;
import co.edu.uco.transformate.business.domain.PruebaFisicaDomain;
import co.edu.uco.transformate.data.dao.factory.DAOFactory;
import co.edu.uco.transformate.entities.PruebaFisicaEntity;

public class PruebaFisicaBusinessImpl implements PruebaFisicaBusiness{
	private final DAOFactory daoFactory;

	public PruebaFisicaBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	
	@Override
	public void create(PruebaFisicaDomain domain) {
		final PruebaFisicaEntity entity = PruebaFisicaAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getPruebaFisicaDAO().create(entity);
		
	}

	@Override
	public List<PruebaFisicaDomain> read(PruebaFisicaDomain domain) {
		final PruebaFisicaEntity entity = PruebaFisicaAssembler.getInstance().toEntityFromDomain(domain);
		final List<PruebaFisicaEntity> resultEntities = daoFactory.getPruebaFisicaDAO().read(entity);
		return PruebaFisicaAssembler.getInstance().toDomainListFromEntityList(resultEntities);
	}

}
