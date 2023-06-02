package co.edu.uco.transformate.business.assembler.concrete;

import java.util.List;

import co.edu.uco.transformate.business.assembler.Assembler;

import co.edu.uco.transformate.business.domain.RecepcionistaDomain;
import co.edu.uco.transformate.crosscutting.utils.UtilDate;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

import co.edu.uco.transformate.dto.RecepcionistaDTO;

import co.edu.uco.transformate.entities.GimnasioEntity;
import co.edu.uco.transformate.entities.RecepcionistaEntity;
import co.edu.uco.transformate.entities.TipoDocumentoEntity;

public class RecepcionistaAssembler implements Assembler<RecepcionistaDomain, RecepcionistaDTO, RecepcionistaEntity>{

	@Override
	public RecepcionistaDTO toDTOFromDomain(RecepcionistaDomain domain) {
		return RecepcionistaDTO.create().setIdentificador(domain.getIdentificador())
				.setTipoDocumentoDTO(TipoDocumentoAssembler.getInstance().toDTOFromDomain(domain.getTipoDocumentoDTO()))
				.setIdentificacion(domain.getIdentificacion()).setNombre(domain.getNombre())
				.setUsuario(domain.getUsuario()).setConstraseña(domain.getConstraseña())
				.setTelefono(domain.getTelefono()).setSalario(domain.getSalario())
				.setGimnasioDTO(GimnasioAssembler.getInstance().toDTOFromDomain(domain.getGimnasioDTO()));
	}

	@Override
	public RecepcionistaDomain toDomainFromDTO(RecepcionistaDTO dto) {
		return new RecepcionistaDomain(dto.getIdentificador(),
				TipoDocumentoAssembler.getInstance().toDomainFromDTO(dto.getTipoDocumentoDTO()),
				dto.getIdentificacion(), dto.getNombre(), dto.getUsuario(), dto.getConstraseña(), dto.getTelefono(),
				dto.getSalario(), GimnasioAssembler.getInstance().toDomainFromDTO(dto.getGimnasioDTO()));
	}

	@Override
	public RecepcionistaEntity toEntityFromDomain(RecepcionistaDomain domain) {
		return new RecepcionistaEntity(domain.getIdentificador(),
				TipoDocumentoEntity.create(UtilUUID.DEFAULT_UUID, UtilText.EMPTY), domain.getIdentificacion(),
				domain.getNombre(), domain.getUsuario(), domain.getConstraseña(), domain.getTelefono(),
				domain.getSalario(), GimnasioEntity.create(UtilUUID.DEFAULT_UUID, UtilText.EMPTY, UtilText.EMPTY,
						UtilText.EMPTY, UtilText.EMPTY, UtilDate.DEFAULT_DATE_TIME, UtilDate.DEFAULT_DATE_TIME));
	}

	@Override
	public RecepcionistaDomain toDomainFromEntity(RecepcionistaEntity entity) {
		return new RecepcionistaDomain(entity.getIdentificador(),
				TipoDocumentoAssembler.getInstance().toDomainFromEntity(entity.getTipoDocumentoDTO()),
				entity.getIdentificacion(), entity.getNombre(), entity.getUsuario(), entity.getConstraseña(),
				entity.getTelefono(), entity.getSalario(),
				GimnasioAssembler.getInstance().toDomainFromEntity(entity.getGimnasioDTO()));
	}

	@Override
	public List<RecepcionistaDomain> toDomainListFromEntityList(List<RecepcionistaEntity> entityList) {
		return entityList.stream().map(this::toDomainFromEntity).toList();
		
	}

	@Override
	public List<RecepcionistaDTO> toDTOListFromDomainList(List<RecepcionistaDomain> domainList) {
		return domainList.stream().map(this::toDTOFromDomain).toList();
	}

}
