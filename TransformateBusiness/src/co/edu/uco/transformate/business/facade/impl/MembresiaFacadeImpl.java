package co.edu.uco.transformate.business.facade.impl;

import java.util.List;


import co.edu.uco.transformate.business.assembler.concrete.MembresiaAssembler;

import co.edu.uco.transformate.business.business.MembresiaBusiness;

import co.edu.uco.transformate.business.business.impl.MembresiaBusinessImpl;

import co.edu.uco.transformate.business.domain.MembresiaDomain;
import co.edu.uco.transformate.business.facade.MembresiaFacade;
import co.edu.uco.transformate.crosscutting.exception.TransformateBusinessException;
import co.edu.uco.transformate.crosscutting.exception.TransformateException;
import co.edu.uco.transformate.crosscutting.utils.Messages.EstadoTipoRelacionInstitucionFacadeImplMessage;
import co.edu.uco.transformate.data.dao.factory.DAOFactory;
import co.edu.uco.transformate.data.dao.factory.Factory;
import co.edu.uco.transformate.dto.MembresiaDTO;

public class MembresiaFacadeImpl implements MembresiaFacade{
	private final DAOFactory daoFactory;
	private final MembresiaBusiness business;

	public MembresiaFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		business = new MembresiaBusinessImpl(daoFactory);
	}
	@Override
	public List<MembresiaDTO> read(MembresiaDTO dto) {
		try {
			final var domain = MembresiaAssembler.getInstance().toDomainFromDTO(dto);
			final var returnDomainList = business.read(domain);

			final List<MembresiaDomain> domainList = returnDomainList;
			return MembresiaAssembler.getInstance().toDTOListFromDomainList(domainList);
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
