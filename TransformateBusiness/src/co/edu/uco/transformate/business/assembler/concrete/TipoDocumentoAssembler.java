package co.edu.uco.transformate.business.assembler.concrete;

import java.util.List;


import co.edu.uco.transformate.business.assembler.Assembler;
import co.edu.uco.transformate.business.domain.TipoDocumentoDomain;
import co.edu.uco.transformate.dto.TipoDocumentoDTO;
import co.edu.uco.transformate.entities.TipoDocumentoEntity;

public class TipoDocumentoAssembler implements Assembler<TipoDocumentoDomain,TipoDocumentoDTO,TipoDocumentoEntity>{

	private static final Assembler<TipoDocumentoDomain,TipoDocumentoDTO,TipoDocumentoEntity> INSTANCE_ASSEMBLER = new TipoDocumentoAssembler();

	private TipoDocumentoAssembler() {
	
	}

	public static final Assembler<TipoDocumentoDomain,TipoDocumentoDTO,TipoDocumentoEntity> getInstance() {
		return INSTANCE_ASSEMBLER;
	}

	@Override
	public TipoDocumentoDTO toDTOFromDomain(TipoDocumentoDomain domain) {
		return TipoDocumentoDTO.create().setIdentificador(domain.getIdentificador())
				.setNombre(domain.getNombre());
	}

	@Override
	public TipoDocumentoDomain toDomainFromDTO(TipoDocumentoDTO dto) {
		return new TipoDocumentoDomain(dto.getIdentificador(), dto.getNombre());
	}

	@Override
	public TipoDocumentoEntity toEntityFromDomain(TipoDocumentoDomain domain) {
		return new TipoDocumentoEntity(domain.getIdentificador(), domain.getNombre());
	}

	@Override
	public TipoDocumentoDomain toDomainFromEntity(TipoDocumentoEntity entity) {
		return new TipoDocumentoDomain(entity.getIdentificador(), entity.getNombre());
	}

	@Override
	public List<TipoDocumentoDomain> toDomainListFromEntityList(List<TipoDocumentoEntity> entityList) {
		return entityList.stream().map(this::toDomainFromEntity).toList();
	}

	@Override
	public List<TipoDocumentoDTO> toDTOListFromDomainList(List<TipoDocumentoDomain> domainList) {
		return domainList.stream().map(this::toDTOFromDomain).toList();
	}

}
