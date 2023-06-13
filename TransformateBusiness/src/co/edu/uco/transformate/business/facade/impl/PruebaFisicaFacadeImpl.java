package co.edu.uco.transformate.business.facade.impl;

import java.util.List;


import co.edu.uco.transformate.business.assembler.concrete.PruebaFisicaAssembler;

import co.edu.uco.transformate.business.business.PruebaFisicaBusiness;

import co.edu.uco.transformate.business.business.impl.PruebaFisicaBusinessImpl;

import co.edu.uco.transformate.business.domain.PruebaFisicaDomain;
import co.edu.uco.transformate.business.facade.PruebaFisicaFacade;
import co.edu.uco.transformate.crosscutting.exception.TransformateBusinessException;
import co.edu.uco.transformate.crosscutting.exception.TransformateException;
import co.edu.uco.transformate.crosscutting.utils.Messages.EstadoTipoRelacionInstitucionFacadeImplMessage;
import co.edu.uco.transformate.data.dao.factory.DAOFactory;
import co.edu.uco.transformate.data.dao.factory.Factory;
import co.edu.uco.transformate.dto.PruebaFisicaDTO;

public class PruebaFisicaFacadeImpl implements PruebaFisicaFacade{
	private final DAOFactory daoFactory;
	private final PruebaFisicaBusiness business;

	public PruebaFisicaFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		business = new PruebaFisicaBusinessImpl(daoFactory);
	}
	@Override
	public void create(PruebaFisicaDTO dto) {
		try {
			daoFactory.initTransaction();
			final PruebaFisicaDomain domain = PruebaFisicaAssembler.getInstance()
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
	public List<PruebaFisicaDTO> read(PruebaFisicaDTO dto) {
		try {
			final var domain = PruebaFisicaAssembler.getInstance().toDomainFromDTO(dto);
			final var returnDomainList = business.read(domain);

			final List<PruebaFisicaDomain> domainList = returnDomainList;
			return PruebaFisicaAssembler.getInstance().toDTOListFromDomainList(domainList);
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
