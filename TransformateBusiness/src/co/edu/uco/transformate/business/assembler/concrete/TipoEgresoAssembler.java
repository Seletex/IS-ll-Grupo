package co.edu.uco.transformate.business.assembler.concrete;

import java.util.List;

import co.edu.uco.transformate.business.assembler.Assembler;
import co.edu.uco.transformate.business.domain.TipoEgresoDomain;

import co.edu.uco.transformate.dto.TipoEgresoDTO;

import co.edu.uco.transformate.entities.TipoEgresoEntity;


public class TipoEgresoAssembler implements Assembler<TipoEgresoDomain, TipoEgresoDTO, TipoEgresoEntity>{

	
	private static final Assembler<TipoEgresoDomain, TipoEgresoDTO, TipoEgresoEntity> INSTANCE_ASSEMBLER = new TipoEgresoAssembler();

	private TipoEgresoAssembler() {

	}

	public static final Assembler<TipoEgresoDomain, TipoEgresoDTO, TipoEgresoEntity> getInstance() {
		return INSTANCE_ASSEMBLER;
	}
	
	@Override
	public TipoEgresoDTO toDTOFromDomain(TipoEgresoDomain domain) {
		return TipoEgresoDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre());
	}

	@Override
	public TipoEgresoDomain toDomainFromDTO(TipoEgresoDTO dto) {
		return new TipoEgresoDomain(dto.getIdentificador(), dto.getNombre());
	}

	@Override
	public TipoEgresoEntity toEntityFromDomain(TipoEgresoDomain domain) {
		return new TipoEgresoEntity(domain.getIdentificador(), domain.getNombre());
	}

	@Override
	public TipoEgresoDomain toDomainFromEntity(TipoEgresoEntity entity) {
		return new TipoEgresoDomain(entity.getIdentificador(), entity.getNombre());
	}

	@Override
	public List<TipoEgresoDomain> toDomainListFromEntityList(List<TipoEgresoEntity> entityList) {
		return entityList.stream().map(this::toDomainFromEntity).toList();
	}

	@Override
	public List<TipoEgresoDTO> toDTOListFromDomainList(List<TipoEgresoDomain> domainList) {
		return domainList.stream().map(this::toDTOFromDomain).toList();
	}

}
