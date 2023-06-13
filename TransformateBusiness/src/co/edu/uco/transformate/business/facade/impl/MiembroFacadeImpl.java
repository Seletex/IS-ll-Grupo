package co.edu.uco.transformate.business.facade.impl;

import java.util.List;


import co.edu.uco.transformate.business.assembler.concrete.MiembroAssembler;

import co.edu.uco.transformate.business.business.MiembroBusiness;

import co.edu.uco.transformate.business.business.impl.MiembroBusinessImpl;

import co.edu.uco.transformate.business.domain.MiembroDomain;
import co.edu.uco.transformate.business.facade.MiembroFacade;
import co.edu.uco.transformate.crosscutting.exception.TransformateBusinessException;
import co.edu.uco.transformate.crosscutting.exception.TransformateException;
import co.edu.uco.transformate.crosscutting.utils.Messages.EstadoTipoRelacionInstitucionFacadeImplMessage;
import co.edu.uco.transformate.data.dao.factory.DAOFactory;
import co.edu.uco.transformate.data.dao.factory.Factory;
import co.edu.uco.transformate.dto.MiembroDTO;

public class MiembroFacadeImpl implements MiembroFacade{
	private final DAOFactory daoFactory;
	private final MiembroBusiness business;

	public MiembroFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		business = new MiembroBusinessImpl(daoFactory);
	}
	@Override
	public void create(MiembroDTO dto) {
		try {
			daoFactory.initTransaction();
			final MiembroDomain domain = MiembroAssembler.getInstance()
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
	public List<MiembroDTO> read(MiembroDTO dto) {
		try {
			final var domain = MiembroAssembler.getInstance().toDomainFromDTO(dto);
			final var returnDomainList = business.read(domain);

			final List<MiembroDomain> domainList = returnDomainList;
			return MiembroAssembler.getInstance().toDTOListFromDomainList(domainList);
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
	public void update(MiembroDTO dto) {
		try {
			daoFactory.initTransaction();
			final MiembroDomain domain = MiembroAssembler.getInstance()
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
