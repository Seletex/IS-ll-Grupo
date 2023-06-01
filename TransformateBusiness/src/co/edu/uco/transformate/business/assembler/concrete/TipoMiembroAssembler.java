package co.edu.uco.transformate.business.assembler.concrete;

import java.util.List;

import co.edu.uco.transformate.business.assembler.Assembler;
import co.edu.uco.transformate.business.domain.TipoMiembroDomain;
import co.edu.uco.transformate.business.domain.TipoRutinaDomain;
import co.edu.uco.transformate.dto.TipoMiembroDTO;
import co.edu.uco.transformate.dto.TipoRutinaDTO;
import co.edu.uco.transformate.entities.TipoMiembroEntity;
import co.edu.uco.transformate.entities.TipoRutinaEntity;

public class TipoMiembroAssembler implements Assembler<TipoMiembroDomain, TipoMiembroDTO, TipoMiembroEntity> {

	private static final Assembler<TipoMiembroDomain, TipoMiembroDTO, TipoMiembroEntity> INSTANCE_ASSEMBLER = new TipoMiembroAssembler();

	private TipoMiembroAssembler() {

	}

	public static final Assembler<TipoMiembroDomain, TipoMiembroDTO, TipoMiembroEntity> getInstance() {
		return INSTANCE_ASSEMBLER;
	}

	@Override
	public TipoMiembroDTO toDTOFromDomain(TipoMiembroDomain domain) {
		return TipoMiembroDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre());
	}

	@Override
	public TipoMiembroDomain toDomainFromDTO(TipoMiembroDTO dto) {
		return new TipoMiembroDomain(dto.getIdentificador(), dto.getNombre(), null);
	}

	@Override
	public TipoMiembroEntity toEntityFromDomain(TipoMiembroDomain domain) {
		return new TipoMiembroEntity(domain.getIdentificador(), domain.getNombre());
	}

	@Override
	public TipoMiembroDomain toDomainFromEntity(TipoMiembroEntity entity) {
		return new TipoMiembroDomain(entity.getIdentificador(), entity.getNombre());
	}

	@Override
	public List<TipoMiembroDomain> toDomainListFromEntityList(List<TipoMiembroEntity> entityList) {
		return entityList.stream().map(this::toDomainFromEntity).toList();
	}

	@Override
	public List<TipoMiembroDTO> toDTOListFromDomainList(List<TipoMiembroDomain> domainList) {
		return domainList.stream().map(this::toDTOFromDomain).toList();
	}

}
