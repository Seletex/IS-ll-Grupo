package co.edu.uco.transformate.business.facade.impl;

import java.util.List;

import co.edu.uco.transformate.business.assembler.concrete.DescuentoAssembler;

import co.edu.uco.transformate.business.business.DescuentoBusiness;

import co.edu.uco.transformate.business.business.impl.DescuentoBusinessImpl;

import co.edu.uco.transformate.business.domain.DescuentoDomain;

import co.edu.uco.transformate.business.facade.DescuentoFacade;
import co.edu.uco.transformate.crosscutting.exception.TransformateBusinessException;
import co.edu.uco.transformate.crosscutting.exception.TransformateException;
import co.edu.uco.transformate.crosscutting.utils.Messages.EstadoTipoRelacionInstitucionFacadeImplMessage;
import co.edu.uco.transformate.data.dao.factory.DAOFactory;
import co.edu.uco.transformate.data.dao.factory.Factory;
import co.edu.uco.transformate.dto.DescuentoDTO;

public class DescuentoFacadeImpl implements DescuentoFacade{
	private final DAOFactory daoFactory;
	private final DescuentoBusiness business;

	public DescuentoFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		business = new DescuentoBusinessImpl(daoFactory);
	}
	@Override
	public void create(DescuentoDTO dto) {
		try {
			daoFactory.initTransaction();
			final DescuentoDomain domain = DescuentoAssembler.getInstance()
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
	public List<DescuentoDTO> read(DescuentoDTO dto) {
		try {
			final var domain = DescuentoAssembler.getInstance().toDomainFromDTO(dto);
			final var returnDomainList = business.read(domain);

			final List<DescuentoDomain> domainList = returnDomainList;
			return DescuentoAssembler.getInstance().toDTOListFromDomainList(domainList);
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
	public void delete(DescuentoDTO dto) {
		try {
			daoFactory.initTransaction();
			final DescuentoDomain domain = DescuentoAssembler.getInstance()
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
