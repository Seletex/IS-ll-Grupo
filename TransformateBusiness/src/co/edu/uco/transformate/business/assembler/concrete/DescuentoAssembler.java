package co.edu.uco.transformate.business.assembler.concrete;

import java.util.List;

import co.edu.uco.transformate.business.assembler.Assembler;
import co.edu.uco.transformate.business.domain.DescuentoDomain;
import co.edu.uco.transformate.business.domain.TipoRutinaDomain;
import co.edu.uco.transformate.dto.DescuentoDTO;
import co.edu.uco.transformate.dto.TipoRutinaDTO;
import co.edu.uco.transformate.entities.DescuentoEntity;
import co.edu.uco.transformate.entities.TipoRutinaEntity;

public class DescuentoAssembler implements Assembler<DescuentoDomain, DescuentoDTO,DescuentoEntity>{

	private static final Assembler<DescuentoDomain, DescuentoDTO,DescuentoEntity> INSTANCE_ASSEMBLER = new DescuentoAssembler();

	private DescuentoAssembler() {

	}

	public static final Assembler<DescuentoDomain, DescuentoDTO,DescuentoEntity> getInstance() {
		return INSTANCE_ASSEMBLER;
	}

	
	@Override
	public DescuentoDTO toDTOFromDomain(DescuentoDomain domain) {
		return DescuentoDTO.create().setIdentificadorUuid(domain.getIdentificadorUuid()).setPorcentaje(domain.getPorcentaje())
				.setTipoDescuentoDTO(TipoDescuentoAssembler.getInstance().toDTOFromDomain(domain.getTipoDescuentoDTO()));
	}

	@Override
	public DescuentoDomain toDomainFromDTO(DescuentoDTO dto) {
		return new DescuentoDomain(dto.getIdentificadorUuid(), dto.getPorcentaje(), dto.getDescripcion());
	}

	@Override
	public DescuentoEntity toEntityFromDomain(DescuentoDomain domain) {
		return new DescuentoEntity(domain.getIdentificadorUuid(), domain.getPorcentaje(), domain.getDescripcion());
	}

	@Override
	public DescuentoDomain toDomainFromEntity(DescuentoEntity entity) {
		return new DescuentoDomain(entity.getIdentificadorUuid(), entity.getPorcentaje(), entity.getDescripcion());
	}

	@Override
	public List<DescuentoDomain> toDomainListFromEntityList(List<DescuentoEntity> entityList) {
		return entityList.stream().map(this::toDomainFromEntity).toList();
	}

	@Override
	public List<DescuentoDTO> toDTOListFromDomainList(List<DescuentoDomain> domainList) {
		return domainList.stream().map(this::toDTOFromDomain).toList();
	}

}
