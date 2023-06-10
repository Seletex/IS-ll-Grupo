package co.edu.uco.transformate.business.business.impl;

import java.util.List;

import co.edu.uco.transformate.business.assembler.Assembler;

import co.edu.uco.transformate.business.domain.MembresiaDomain;

import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

import co.edu.uco.transformate.dto.MembresiaDTO;

import co.edu.uco.transformate.entities.MembresiaEntity;

import co.edu.uco.transformate.entities.TipoMembresiaEntity;

public class MembresiaAssembler implements Assembler<MembresiaDomain, MembresiaDTO, MembresiaEntity> {

	private static final Assembler<MembresiaDomain, MembresiaDTO, MembresiaEntity> INSTANCE_ASSEMBLER = new MembresiaAssembler();

	private MembresiaAssembler() {

	}

	public static final Assembler<MembresiaDomain, MembresiaDTO, MembresiaEntity> getInstance() {
		return INSTANCE_ASSEMBLER;
	}

	@Override
	public MembresiaDTO toDTOFromDomain(MembresiaDomain domain) {
		return MembresiaDTO.create();
	}

	@Override
	public MembresiaDomain toDomainFromDTO(MembresiaDTO dto) {
		return new MembresiaDomain(dto.getIdentificador(),

				TipoMembresiaAssembler.getInstance().toDomainFromDTO(dto.getTipoMembresiaDTO()), dto.getFechaInicio(),
				dto.getFechaFin());
	}

	@Override
	public MembresiaEntity toEntityFromDomain(MembresiaDomain domain) {
		return new MembresiaEntity(domain.getIdentificador(), TipoMembresiaEntity.create(UtilUUID.DEFAULT_UUID,UtilText.EMPTY	), domain.getFechaFin(),
				
				domain.getFechaInicio());
	}

	@Override
	public MembresiaDomain toDomainFromEntity(MembresiaEntity entity) {
		return new MembresiaDomain(entity.getIdentificador(),

				TipoMembresiaAssembler.getInstance().toDomainFromEntity(entity.getTipoMembresiaDTO()), entity.getFechaFin(),
				entity.getFechaInicio());
	}

	@Override
	public List<MembresiaDomain> toDomainListFromEntityList(List<MembresiaEntity> entityList) {
		return entityList.stream().map(this::toDomainFromEntity).toList();
	}

	@Override
	public List<MembresiaDTO> toDTOListFromDomainList(List<MembresiaDomain> domainList) {
		return domainList.stream().map(this::toDTOFromDomain).toList();
	}

}
