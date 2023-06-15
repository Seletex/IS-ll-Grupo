package co.edu.uco.transformate.business.facade.impl;

import java.util.List;

import co.edu.uco.transformate.business.assembler.concrete.TipoMembresiaAssembler;
import co.edu.uco.transformate.business.business.TipoMembresiaBusiness;
import co.edu.uco.transformate.business.business.impl.TipoMembresiaBusinessImpl;
import co.edu.uco.transformate.business.domain.TipoMembresiaDomain;
import co.edu.uco.transformate.business.facade.TipoMembresiaFacade;
import co.edu.uco.transformate.crosscutting.exception.TransformateBusinessException;
import co.edu.uco.transformate.crosscutting.exception.TransformateException;
import co.edu.uco.transformate.crosscutting.utils.Messages.EstadoTipoRelacionInstitucionFacadeImplMessage;
import co.edu.uco.transformate.data.dao.factory.DAOFactory;
import co.edu.uco.transformate.data.dao.factory.Factory;
import co.edu.uco.transformate.dto.TipoMembresiaDTO;

public class TipoMembresiaFacadeImpl implements TipoMembresiaFacade{
	private final DAOFactory daoFactory;
	private final TipoMembresiaBusiness business;

	public TipoMembresiaFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		business = new TipoMembresiaBusinessImpl(daoFactory);
	}
	@Override
	public List<TipoMembresiaDTO> read(TipoMembresiaDTO dto) {
		try {
			final var domain = TipoMembresiaAssembler.getInstance().toDomainFromDTO(dto);
			final var returnDomainList = business.read(domain);

			final List<TipoMembresiaDomain> domainList = returnDomainList;
			return TipoMembresiaAssembler.getInstance().toDTOListFromDomainList(domainList);
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
