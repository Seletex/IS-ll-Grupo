package co.edu.uco.transformate.business.assembler.concrete;

import java.util.List;

import co.edu.uco.transformate.business.assembler.Assembler;
import co.edu.uco.transformate.business.domain.TipoPagoDomain;

import co.edu.uco.transformate.dto.TipoPagoDTO;

import co.edu.uco.transformate.entities.TipoPagoEntity;


public class TipoPagoAssembler implements Assembler<TipoPagoDomain, TipoPagoDTO, TipoPagoEntity> {

	private static final Assembler<TipoPagoDomain, TipoPagoDTO, TipoPagoEntity> INSTANCE_ASSEMBLER = new TipoPagoAssembler();

	private TipoPagoAssembler() {

	}

	public static final Assembler<TipoPagoDomain, TipoPagoDTO, TipoPagoEntity> getInstance() {
		return INSTANCE_ASSEMBLER;
	}

	@Override
	public TipoPagoDTO toDTOFromDomain(TipoPagoDomain domain) {
		return TipoPagoDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre());
	}

	@Override
	public TipoPagoDomain toDomainFromDTO(TipoPagoDTO dto) {
		return new TipoPagoDomain(dto.getIdentificador(), dto.getNombre());
	}

	@Override
	public TipoPagoEntity toEntityFromDomain(TipoPagoDomain domain) {
		return new TipoPagoEntity(domain.getIdentificador(), domain.getNombre());
	}

	@Override
	public TipoPagoDomain toDomainFromEntity(TipoPagoEntity entity) {
		return new TipoPagoDomain(entity.getIdentificador(), entity.getNombre());
	}

	@Override
	public List<TipoPagoDomain> toDomainListFromEntityList(List<TipoPagoEntity> entityList) {
		return entityList.stream().map(this::toDomainFromEntity).toList();
	}

	@Override
	public List<TipoPagoDTO> toDTOListFromDomainList(List<TipoPagoDomain> domainList) {
		return domainList.stream().map(this::toDTOFromDomain).toList();
	}

}
