package co.edu.uco.transformate.business.assembler.concrete;

import java.util.List;

import co.edu.uco.transformate.business.assembler.Assembler;
import co.edu.uco.transformate.business.domain.NivelDificultadDomain;

import co.edu.uco.transformate.dto.NivelDificultadDTO;

import co.edu.uco.transformate.entities.NivelDificultadEntity;


public class NivelDificultadAssembler implements Assembler<NivelDificultadDomain, NivelDificultadDTO, NivelDificultadEntity>{

	private static final Assembler<NivelDificultadDomain, NivelDificultadDTO, NivelDificultadEntity> INSTANCE_ASSEMBLER = new NivelDificultadAssembler();

	private NivelDificultadAssembler() {

	}

	public static final Assembler<NivelDificultadDomain, NivelDificultadDTO, NivelDificultadEntity> getInstance() {
		return INSTANCE_ASSEMBLER;
	}
	
	@Override
	public NivelDificultadDTO toDTOFromDomain(NivelDificultadDomain domain) {
		return NivelDificultadDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre());
	}

	@Override
	public NivelDificultadDomain toDomainFromDTO(NivelDificultadDTO dto) {
		return new NivelDificultadDomain(dto.getIdentificador(), dto.getNombre());
	
	}

	@Override
	public NivelDificultadEntity toEntityFromDomain(NivelDificultadDomain domain) {
		return new NivelDificultadEntity(domain.getIdentificador(), domain.getNombre());
	}

	@Override
	public NivelDificultadDomain toDomainFromEntity(NivelDificultadEntity entity) {
		return new NivelDificultadDomain(entity.getIdentificador(), entity.getNombre());
	}

	@Override
	public List<NivelDificultadDomain> toDomainListFromEntityList(List<NivelDificultadEntity> entityList) {
		return entityList.stream().map(this::toDomainFromEntity).toList();
	}

	@Override
	public List<NivelDificultadDTO> toDTOListFromDomainList(List<NivelDificultadDomain> domainList) {
		return domainList.stream().map(this::toDTOFromDomain).toList();
	}

}
