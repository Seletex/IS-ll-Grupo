package co.edu.uco.transformate.business.assembler.concrete;

import java.util.List;

import co.edu.uco.transformate.business.assembler.Assembler;
import co.edu.uco.transformate.business.domain.TipoMembresiaDomain;

import co.edu.uco.transformate.dto.TipoMembresiaDTO;

import co.edu.uco.transformate.entities.TipoMembresiaEntity;


public class TipoMembresiaAssembler implements Assembler<TipoMembresiaDomain, TipoMembresiaDTO, TipoMembresiaEntity>{

	private static final Assembler<TipoMembresiaDomain, TipoMembresiaDTO, TipoMembresiaEntity> INSTANCE_ASSEMBLER = new TipoMembresiaAssembler();

	private TipoMembresiaAssembler() {

	}

	public static final Assembler<TipoMembresiaDomain, TipoMembresiaDTO, TipoMembresiaEntity> getInstance() {
		return INSTANCE_ASSEMBLER;
	}

	
	@Override
	public TipoMembresiaDTO toDTOFromDomain(TipoMembresiaDomain domain) {
		return TipoMembresiaDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre());
	}

	@Override
	public TipoMembresiaDomain toDomainFromDTO(TipoMembresiaDTO dto) {
		return new TipoMembresiaDomain(dto.getIdentificador(), dto.getNombre());
	}

	@Override
	public TipoMembresiaEntity toEntityFromDomain(TipoMembresiaDomain domain) {
		return new TipoMembresiaEntity(domain.getIdentificador(), domain.getNombre());
	}

	@Override
	public TipoMembresiaDomain toDomainFromEntity(TipoMembresiaEntity entity) {
		return new TipoMembresiaDomain(entity.getIdentificador(), entity.getNombre());
	}

	@Override
	public List<TipoMembresiaDomain> toDomainListFromEntityList(List<TipoMembresiaEntity> entityList) {
		return entityList.stream().map(this::toDomainFromEntity).toList();
	}

	@Override
	public List<TipoMembresiaDTO> toDTOListFromDomainList(List<TipoMembresiaDomain> domainList) {
		return domainList.stream().map(this::toDTOFromDomain).toList();
	}

}
