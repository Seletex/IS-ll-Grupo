package co.edu.uco.transformate.business.facade.impl;

import java.util.List;

import co.edu.uco.transformate.business.assembler.concrete.GimnasioAssembler;
import co.edu.uco.transformate.business.business.GimnasioBusiness;
import co.edu.uco.transformate.business.business.impl.GimnasioBusinessImpl;
import co.edu.uco.transformate.business.domain.GimnasioDomain;
import co.edu.uco.transformate.business.facade.GimnasioFacade;
import co.edu.uco.transformate.crosscutting.exception.TransformateBusinessException;
import co.edu.uco.transformate.crosscutting.exception.TransformateException;
import co.edu.uco.transformate.crosscutting.utils.Messages.EstadoTipoRelacionInstitucionFacadeImplMessage;
import co.edu.uco.transformate.data.dao.factory.DAOFactory;
import co.edu.uco.transformate.data.dao.factory.Factory;
import co.edu.uco.transformate.dto.GimnasioDTO;

public class GimnasioFacadeImpl implements GimnasioFacade {

	private final DAOFactory daoFactory;
	private final GimnasioBusiness business;

	public GimnasioFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		business = new GimnasioBusinessImpl(daoFactory);
	}
	
	
	@Override
	public void create(GimnasioDTO dto) {
		try {
			daoFactory.initTransaction();
			final GimnasioDomain domain = GimnasioAssembler.getInstance()
					.toDomainFromDTO(dto);

			business.create(domain);
			daoFactory.commitTransaction();
		} catch (final TransformateException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.cancelarTransaccion();


			throw TransformateBusinessException.create(EstadoTipoRelacionInstitucionFacadeImplMessage.REGISTER_EXCEPTION_TECHNICAL_MESSAGE_STRING,  EstadoTipoRelacionInstitucionFacadeImplMessage.REGISTER_EXCEPTION_USER_MESSAGE_STRING, exception);
		} finally {
			daoFactory.cerrarConexion();
		}

		
	}

	@Override
	public List<GimnasioDTO> read(GimnasioDTO dto) {
		try {
			final var domain = GimnasioAssembler.getInstance().toDomainFromDTO(dto);
			final var returnDomainList = business.read(domain);

			final List<GimnasioDomain> domainList = returnDomainList;
			return GimnasioAssembler.getInstance().toDTOListFromDomainList(domainList);
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

	@Override
	public void update(GimnasioDTO dto) {
		try {
			daoFactory.initTransaction();
			final GimnasioDomain domain = GimnasioAssembler.getInstance()
					.toDomainFromDTO(dto);

			business.update(domain);
			daoFactory.commitTransaction();
		} catch (final TransformateException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.cancelarTransaccion();


			throw TransformateBusinessException.create(EstadoTipoRelacionInstitucionFacadeImplMessage.REGISTER_EXCEPTION_TECHNICAL_MESSAGE_STRING, EstadoTipoRelacionInstitucionFacadeImplMessage.REGISTER_EXCEPTION_USER_MESSAGE_STRING, exception);
		} finally {
			daoFactory.cerrarConexion();
		}
		
	}

}
