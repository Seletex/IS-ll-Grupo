package co.edu.uco.transformate.business.facade.impl;

import java.util.List;


import co.edu.uco.transformate.business.assembler.concrete.ObjetivoEntrenamientoAssembler;

import co.edu.uco.transformate.business.business.ObjetivoEntrenamientoBusiness;

import co.edu.uco.transformate.business.business.impl.ObjetivoEntrenamientoBusinessImpl;

import co.edu.uco.transformate.business.domain.ObjetivoEntrenamientoDomain;
import co.edu.uco.transformate.business.facade.ObjetivoEntrenamientoFacade;
import co.edu.uco.transformate.crosscutting.exception.TransformateBusinessException;
import co.edu.uco.transformate.crosscutting.exception.TransformateException;
import co.edu.uco.transformate.crosscutting.utils.Messages.EstadoTipoRelacionInstitucionFacadeImplMessage;
import co.edu.uco.transformate.data.dao.factory.DAOFactory;
import co.edu.uco.transformate.data.dao.factory.Factory;
import co.edu.uco.transformate.dto.ObjetivoEntrenamientoDTO;

public class ObjetivoEntrenamientoFacadeImpl implements ObjetivoEntrenamientoFacade{
	private final DAOFactory daoFactory;
	private final ObjetivoEntrenamientoBusiness business;

	public ObjetivoEntrenamientoFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		business = new ObjetivoEntrenamientoBusinessImpl(daoFactory);
	}
	@Override
	public List<ObjetivoEntrenamientoDTO> read(ObjetivoEntrenamientoDTO dto) {
		try {
			final var domain = ObjetivoEntrenamientoAssembler.getInstance().toDomainFromDTO(dto);
			final var returnDomainList = business.read(domain);

			final List<ObjetivoEntrenamientoDomain> domainList = returnDomainList;
			return ObjetivoEntrenamientoAssembler.getInstance().toDTOListFromDomainList(domainList);
		} catch (final TransformateException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.cancelarTransaccion();

			throw TransformateBusinessException.create(
					EstadoTipoRelacionInstitucionFacadeImplMessage.REGISTER_EXCEPTION_TECHNICAL_MESSAGE_STRING,
					EstadoTipoRelacionInstitucionFacadeImplMessage.REGISTER_EXCEPTION_USER_MESSAGE_STRING, exception);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

}
