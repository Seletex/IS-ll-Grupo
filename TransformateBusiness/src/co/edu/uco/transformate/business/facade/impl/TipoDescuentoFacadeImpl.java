package co.edu.uco.transformate.business.facade.impl;

import java.util.List;


import co.edu.uco.transformate.business.assembler.concrete.TipoDescuentoAssembler;

import co.edu.uco.transformate.business.business.TipoDescuentoBusiness;
import co.edu.uco.transformate.business.business.impl.TipoDescuentoBusinessImpl;

import co.edu.uco.transformate.business.domain.TipoDescuentoDomain;
import co.edu.uco.transformate.business.facade.TipoDescuentoFacade;
import co.edu.uco.transformate.crosscutting.exception.TransformateBusinessException;
import co.edu.uco.transformate.crosscutting.exception.TransformateException;
import co.edu.uco.transformate.crosscutting.utils.Messages.EstadoTipoRelacionInstitucionFacadeImplMessage;
import co.edu.uco.transformate.data.dao.factory.DAOFactory;
import co.edu.uco.transformate.data.dao.factory.Factory;
import co.edu.uco.transformate.dto.TipoDescuentoDTO;

public class TipoDescuentoFacadeImpl implements TipoDescuentoFacade{
	private final DAOFactory daoFactory;
	private final TipoDescuentoBusiness business;

	public TipoDescuentoFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		business = new TipoDescuentoBusinessImpl(daoFactory);
	}
	@Override
	public List<TipoDescuentoDTO> read(TipoDescuentoDTO dto) {
		try {
			final var domain = TipoDescuentoAssembler.getInstance().toDomainFromDTO(dto);
			final var returnDomainList = business.read(domain);

			final List<TipoDescuentoDomain> domainList = returnDomainList;
			return TipoDescuentoAssembler.getInstance().toDTOListFromDomainList(domainList);
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
