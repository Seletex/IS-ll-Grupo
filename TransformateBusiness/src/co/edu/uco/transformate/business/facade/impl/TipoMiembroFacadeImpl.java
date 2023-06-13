package co.edu.uco.transformate.business.facade.impl;

import java.util.List;


import co.edu.uco.transformate.business.assembler.concrete.TipoMiembroAssembler;

import co.edu.uco.transformate.business.business.TipoMiembroBusiness;

import co.edu.uco.transformate.business.business.impl.TipoMiembroBusinessImpl;

import co.edu.uco.transformate.business.domain.TipoMiembroDomain;
import co.edu.uco.transformate.business.facade.TipoMiembroFacade;
import co.edu.uco.transformate.crosscutting.exception.TransformateBusinessException;
import co.edu.uco.transformate.crosscutting.exception.TransformateException;
import co.edu.uco.transformate.crosscutting.utils.Messages.EstadoTipoRelacionInstitucionFacadeImplMessage;
import co.edu.uco.transformate.data.dao.factory.DAOFactory;
import co.edu.uco.transformate.data.dao.factory.Factory;
import co.edu.uco.transformate.dto.TipoMiembroDTO;

public class TipoMiembroFacadeImpl implements TipoMiembroFacade{
	private final DAOFactory daoFactory;
	private final TipoMiembroBusiness business;

	public TipoMiembroFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		business = new TipoMiembroBusinessImpl(daoFactory);
	}
	@Override
	public List<TipoMiembroDTO> read(TipoMiembroDTO dto) {
		try {
			final var domain = TipoMiembroAssembler.getInstance().toDomainFromDTO(dto);
			final var returnDomainList = business.read(domain);

			final List<TipoMiembroDomain> domainList = returnDomainList;
			return TipoMiembroAssembler.getInstance().toDTOListFromDomainList(domainList);
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
