package co.edu.uco.transformate.business.assembler.concrete;

import java.util.List;

import co.edu.uco.transformate.business.assembler.Assembler;
import co.edu.uco.transformate.business.domain.TipoDescuentoDomain;

import co.edu.uco.transformate.dto.TipoDescuentoDTO;

import co.edu.uco.transformate.entities.TipoDescuentoEntity;


public class TipoDescuentoAssembler implements Assembler<TipoDescuentoDomain, TipoDescuentoDTO,TipoDescuentoEntity>{

	private static final Assembler<TipoDescuentoDomain, TipoDescuentoDTO,TipoDescuentoEntity> INSTANCE_ASSEMBLER = new TipoDescuentoAssembler();

	private TipoDescuentoAssembler() {

	}

	public static final Assembler<TipoDescuentoDomain, TipoDescuentoDTO,TipoDescuentoEntity> getInstance() {
		return INSTANCE_ASSEMBLER;
	}
	
	@Override
	public TipoDescuentoDTO toDTOFromDomain(TipoDescuentoDomain domain) {
		return TipoDescuentoDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre())
			;
	}

	@Override
	public TipoDescuentoDomain toDomainFromDTO(TipoDescuentoDTO dto) {
		return new TipoDescuentoDomain(dto.getIdentificador(), dto.getNombre());
	}

	@Override
	public TipoDescuentoEntity toEntityFromDomain(TipoDescuentoDomain domain) {
		return new TipoDescuentoEntity(domain.getIdentificador(), domain.getNombre());
	}

	@Override
	public TipoDescuentoDomain toDomainFromEntity(TipoDescuentoEntity entity) {
		return new TipoDescuentoDomain(entity.getIdentificador(), entity.getNombre());
	}

	@Override
	public List<TipoDescuentoDomain> toDomainListFromEntityList(List<TipoDescuentoEntity> entityList) {
		return entityList.stream().map(this::toDomainFromEntity).toList();
	}

	@Override
	public List<TipoDescuentoDTO> toDTOListFromDomainList(List<TipoDescuentoDomain> domainList) {
		return domainList.stream().map(this::toDTOFromDomain).toList();
	}

}
