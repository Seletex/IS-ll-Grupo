package co.edu.uco.transformate.business.assembler.concrete;

import java.util.List;

import co.edu.uco.transformate.business.assembler.Assembler;
import co.edu.uco.transformate.business.domain.PlanEntrenamientoDomain;

import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;
import co.edu.uco.transformate.dto.PlanEntrenamientoDTO;

import co.edu.uco.transformate.entities.NivelDificultadEntity;
import co.edu.uco.transformate.entities.PlanEntrenamientoEntity;


public class PlanEntrenamientoAssembler
		implements Assembler<PlanEntrenamientoDomain, PlanEntrenamientoDTO, PlanEntrenamientoEntity> {

	private static final Assembler<PlanEntrenamientoDomain, PlanEntrenamientoDTO, PlanEntrenamientoEntity> INSTANCE_ASSEMBLER = new PlanEntrenamientoAssembler();

	private PlanEntrenamientoAssembler() {

	}

	public static final Assembler<PlanEntrenamientoDomain, PlanEntrenamientoDTO, PlanEntrenamientoEntity> getInstance() {
		return INSTANCE_ASSEMBLER;
	}

	@Override
	public PlanEntrenamientoDTO toDTOFromDomain(PlanEntrenamientoDomain domain) {
		return PlanEntrenamientoDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre())
				.setDescripcion(domain.getDescripcion())
				.setNivel(NivelDificultadAssembler.getInstance().toDTOFromDomain(domain.getNivel()));
	}

	@Override
	public PlanEntrenamientoDomain toDomainFromDTO(PlanEntrenamientoDTO dto) {
		return new PlanEntrenamientoDomain(dto.getIdentificador(), dto.getNombre(), dto.getDescripcion(),
				NivelDificultadAssembler.getInstance().toDomainFromDTO(dto.getNivel()));
	}

	@Override
	public PlanEntrenamientoEntity toEntityFromDomain(PlanEntrenamientoDomain domain) {
		return new PlanEntrenamientoEntity(domain.getIdentificador(), domain.getNombre(), domain.getDescripcion(),
				NivelDificultadEntity.create(UtilUUID.DEFAULT_UUID, UtilText.EMPTY));
	}

	@Override
	public PlanEntrenamientoDomain toDomainFromEntity(PlanEntrenamientoEntity entity) {
		return new PlanEntrenamientoDomain(entity.getIdentificador(), entity.getNombre(), entity.getDescripcion(),
				NivelDificultadAssembler.getInstance().toDomainFromEntity(entity.getNivel()));
	}

	@Override
	public List<PlanEntrenamientoDomain> toDomainListFromEntityList(List<PlanEntrenamientoEntity> entityList) {
		return entityList.stream().map(this::toDomainFromEntity).toList();
	}

	@Override
	public List<PlanEntrenamientoDTO> toDTOListFromDomainList(List<PlanEntrenamientoDomain> domainList) {
		return domainList.stream().map(this::toDTOFromDomain).toList();
	}

}
