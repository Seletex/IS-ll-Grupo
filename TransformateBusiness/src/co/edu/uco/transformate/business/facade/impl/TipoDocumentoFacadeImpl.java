package co.edu.uco.transformate.business.facade.impl;

import java.util.List;

import co.edu.uco.transformate.business.assembler.concrete.TipoDocumentoAssembler;
import co.edu.uco.transformate.business.business.TipoDocumentoBusiness;
import co.edu.uco.transformate.business.business.impl.TipoDocumentoBusinessImpl;
import co.edu.uco.transformate.business.domain.TipoDocumentoDomain;
import co.edu.uco.transformate.business.facade.TipoDocumentoFacade;
import co.edu.uco.transformate.crosscutting.exception.TransformateBusinessException;
import co.edu.uco.transformate.crosscutting.exception.TransformateException;
import co.edu.uco.transformate.crosscutting.utils.Messages.EstadoTipoRelacionInstitucionFacadeImplMessage;
import co.edu.uco.transformate.data.dao.factory.DAOFactory;
import co.edu.uco.transformate.data.dao.factory.Factory;
import co.edu.uco.transformate.dto.TipoDocumentoDTO;

public class TipoDocumentoFacadeImpl implements TipoDocumentoFacade {

	private final DAOFactory daoFactory;
	private final TipoDocumentoBusiness business;

	public TipoDocumentoFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		business = new TipoDocumentoBusinessImpl(daoFactory);
	}

	@Override
	public List<TipoDocumentoDTO> read(TipoDocumentoDTO dto) {
		try {
			final var domain = TipoDocumentoAssembler.getInstance().toDomainFromDTO(dto);
			final var returnDomainList = business.read(domain);

			final List<TipoDocumentoDomain> domainList = returnDomainList;
			return TipoDocumentoAssembler.getInstance().toDTOListFromDomainList(domainList);
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
