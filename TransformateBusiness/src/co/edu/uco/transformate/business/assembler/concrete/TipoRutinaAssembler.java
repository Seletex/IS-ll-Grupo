package co.edu.uco.transformate.business.assembler.concrete;

import java.util.List;

import co.edu.uco.transformate.business.assembler.Assembler;

import co.edu.uco.transformate.business.domain.TipoRutinaDomain;

import co.edu.uco.transformate.dto.TipoRutinaDTO;

import co.edu.uco.transformate.entities.TipoRutinaEntity;

public class TipoRutinaAssembler implements Assembler<TipoRutinaDomain, TipoRutinaDTO, TipoRutinaEntity> {

	private static final Assembler<TipoRutinaDomain, TipoRutinaDTO, TipoRutinaEntity> INSTANCE_ASSEMBLER = new TipoRutinaAssembler();

	private TipoRutinaAssembler() {

	}

	public static final Assembler<TipoRutinaDomain, TipoRutinaDTO, TipoRutinaEntity> getInstance() {
		return INSTANCE_ASSEMBLER;
	}

	@Override
	public TipoRutinaDTO toDTOFromDomain(TipoRutinaDomain domain) {
		return TipoRutinaDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre())
				.setDescripcion(domain.getDescripcion());
	}

	@Override
	public TipoRutinaDomain toDomainFromDTO(TipoRutinaDTO dto) {
		return new TipoRutinaDomain(dto.getIdentificador(), dto.getNombre(), dto.getDescripcion());
	}

	@Override
	public TipoRutinaEntity toEntityFromDomain(TipoRutinaDomain domain) {
		return new TipoRutinaEntity(domain.getIdentificador(), domain.getNombre(), domain.getDescripcion());
	}

	@Override
	public TipoRutinaDomain toDomainFromEntity(TipoRutinaEntity entity) {
		return new TipoRutinaDomain(entity.getIdentificador(), entity.getNombre(), entity.getDescripcion());
	}

	@Override
	public List<TipoRutinaDomain> toDomainListFromEntityList(List<TipoRutinaEntity> entityList) {
		return entityList.stream().map(this::toDomainFromEntity).toList();
	}

	@Override
	public List<TipoRutinaDTO> toDTOListFromDomainList(List<TipoRutinaDomain> domainList) {
		return domainList.stream().map(this::toDTOFromDomain).toList();
	}
}
