package co.edu.uco.transformate.business.facade.impl;

import java.util.List;


import co.edu.uco.transformate.business.assembler.concrete.EntrenadorAssembler;
import co.edu.uco.transformate.business.business.EntrenadorBusiness;
import co.edu.uco.transformate.business.business.impl.EntrenadorBusinessImpl;
import co.edu.uco.transformate.business.domain.EntrenadorDomain;
import co.edu.uco.transformate.business.facade.EntrenadorFacade;
import co.edu.uco.transformate.crosscutting.exception.TransformateBusinessException;
import co.edu.uco.transformate.crosscutting.exception.TransformateException;
import co.edu.uco.transformate.crosscutting.utils.Messages.EstadoTipoRelacionInstitucionFacadeImplMessage;
import co.edu.uco.transformate.data.dao.factory.DAOFactory;
import co.edu.uco.transformate.data.dao.factory.Factory;
import co.edu.uco.transformate.dto.EntrenadorDTO;

public class EntrenadorFacadeImpl implements EntrenadorFacade{

	private final DAOFactory daoFactory;
	private final EntrenadorBusiness business;

	public EntrenadorFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		business = new EntrenadorBusinessImpl(daoFactory);
	}
	
	@Override
	public void create(EntrenadorDTO dto) {
		try {
			daoFactory.initTransaction();
			final EntrenadorDomain domain = EntrenadorAssembler.getInstance()
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
	public List<EntrenadorDTO> read(EntrenadorDTO dto) {
		
			try {
				final var domain = EntrenadorAssembler.getInstance().toDomainFromDTO(dto);
				final var returnDomainList = business.read(domain);

				final List<EntrenadorDomain> domainList = returnDomainList;
				return EntrenadorAssembler.getInstance().toDTOListFromDomainList(domainList);
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
	public void update(EntrenadorDTO dto) {
		try {
			daoFactory.initTransaction();
			final EntrenadorDomain domain = EntrenadorAssembler.getInstance()
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

	@Override
	public void delete(EntrenadorDTO dto) {
		try {
			daoFactory.initTransaction();
			final EntrenadorDomain domain = EntrenadorAssembler.getInstance()
					.toDomainFromDTO(dto);

			business.delete(domain);
			daoFactory.commitTransaction();
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
 