package co.edu.uco.transformate.business.assembler.concrete;

import java.util.List;

import co.edu.uco.transformate.business.assembler.Assembler;
import co.edu.uco.transformate.business.domain.GimnasioDomain;

import co.edu.uco.transformate.dto.GimnasioDTO;

import co.edu.uco.transformate.entities.GimnasioEntity;


public class GimnasioAssembler implements Assembler<GimnasioDomain, GimnasioDTO, GimnasioEntity> {

	private static final Assembler<GimnasioDomain, GimnasioDTO, GimnasioEntity> INSTANCE_ASSEMBLER = new GimnasioAssembler();

	private GimnasioAssembler() {

	}

	public static final Assembler<GimnasioDomain, GimnasioDTO, GimnasioEntity> getInstance() {
		return INSTANCE_ASSEMBLER;
	}

	@Override
	public GimnasioDTO toDTOFromDomain(GimnasioDomain domain) {
		return GimnasioDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre())
				.setDescripcionString(domain.getDescripcionString()).setCorreoString(domain.getCorreoString())
				.setTelefonoString(domain.getTelefonoString()).setHoraAperturaDate(domain.getHoraAperturaDate())
				.setHoraCierreDate(domain.getHoraCierreDate());
	}

	@Override
	public GimnasioDomain toDomainFromDTO(GimnasioDTO dto) {
		return new GimnasioDomain(dto.getIdentificador(), dto.getNombre(), dto.getDescripcionString(),
				dto.getCorreoString(), dto.getTelefonoString(), dto.getHoraAperturaDate(), dto.getHoraCierreDate());
	}

	@Override
	public GimnasioEntity toEntityFromDomain(GimnasioDomain domain) {
		return new GimnasioEntity(domain.getIdentificador(), domain.getNombre(), domain.getDescripcionString(),
				domain.getCorreoString(), domain.getTelefonoString(), domain.getHoraAperturaDate(),
				domain.getHoraCierreDate());
	}

	@Override
	public GimnasioDomain toDomainFromEntity(GimnasioEntity entity) {
		return new GimnasioDomain(entity.getIdentificador(), entity.getNombre(), entity.getDescripcionString(),
				entity.getCorreoString(), entity.getTelefonoString(), entity.getHoraAperturaDate(), entity.getHoraCierreDate());
	}

	@Override
	public List<GimnasioDomain> toDomainListFromEntityList(List<GimnasioEntity> entityList) {
		return entityList.stream().map(this::toDomainFromEntity).toList();
	}

	@Override
	public List<GimnasioDTO> toDTOListFromDomainList(List<GimnasioDomain> domainList) {
		return domainList.stream().map(this::toDTOFromDomain).toList();
	}

}
