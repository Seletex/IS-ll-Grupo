package co.edu.uco.transformate.business.assembler.concrete;

import java.util.List;

import co.edu.uco.transformate.business.assembler.Assembler;
import co.edu.uco.transformate.business.domain.ObjetivoEntrenamientoDomain;

import co.edu.uco.transformate.dto.ObjetivoEntrenamientoDTO;

import co.edu.uco.transformate.entities.ObjetivoEntrenamientoEntity;


public class ObjetivoEntrenamientoAssembler implements Assembler<ObjetivoEntrenamientoDomain, ObjetivoEntrenamientoDTO, ObjetivoEntrenamientoEntity>{

	private static final Assembler<ObjetivoEntrenamientoDomain, ObjetivoEntrenamientoDTO, ObjetivoEntrenamientoEntity> INSTANCE_ASSEMBLER = new ObjetivoEntrenamientoAssembler();

	private ObjetivoEntrenamientoAssembler() {

	}

	public static final Assembler<ObjetivoEntrenamientoDomain, ObjetivoEntrenamientoDTO, ObjetivoEntrenamientoEntity> getInstance() {
		return INSTANCE_ASSEMBLER;
	}
	@Override
	public ObjetivoEntrenamientoDTO toDTOFromDomain(ObjetivoEntrenamientoDomain domain) {
		return ObjetivoEntrenamientoDTO.create().setIdentificador(domain.getIdentificador()).setDescripcion(domain.getDescripcion());
	}

	@Override
	public ObjetivoEntrenamientoDomain toDomainFromDTO(ObjetivoEntrenamientoDTO dto) {
		return new ObjetivoEntrenamientoDomain(dto.getIdentificador(), dto.getDescripcion()
				);
	}

	@Override
	public ObjetivoEntrenamientoEntity toEntityFromDomain(ObjetivoEntrenamientoDomain domain) {
		return new ObjetivoEntrenamientoEntity(domain.getIdentificador(), domain.getDescripcion()
				);
	}

	@Override
	public ObjetivoEntrenamientoDomain toDomainFromEntity(ObjetivoEntrenamientoEntity entity) {
		return new ObjetivoEntrenamientoDomain(entity.getIdentificador(), entity.getDescripcion()
				);
	}

	@Override
	public List<ObjetivoEntrenamientoDomain> toDomainListFromEntityList(List<ObjetivoEntrenamientoEntity> entityList) {
		return entityList.stream().map(this::toDomainFromEntity).toList();
	}

	@Override
	public List<ObjetivoEntrenamientoDTO> toDTOListFromDomainList(List<ObjetivoEntrenamientoDomain> domainList) {
		return domainList.stream().map(this::toDTOFromDomain).toList();
	}

}
