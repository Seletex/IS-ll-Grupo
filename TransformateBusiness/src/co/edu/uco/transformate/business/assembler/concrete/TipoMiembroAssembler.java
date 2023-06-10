package co.edu.uco.transformate.business.assembler.concrete;

import java.util.List;

import co.edu.uco.transformate.business.assembler.Assembler;
import co.edu.uco.transformate.business.domain.TipoMiembroDomain;
import co.edu.uco.transformate.crosscutting.utils.UtilNumber;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;
import co.edu.uco.transformate.dto.TipoMiembroDTO;
import co.edu.uco.transformate.entities.DescuentoEntity;
import co.edu.uco.transformate.entities.TipoDescuentoEntity;
import co.edu.uco.transformate.entities.TipoMiembroEntity;

public class TipoMiembroAssembler implements Assembler<TipoMiembroDomain, TipoMiembroDTO, TipoMiembroEntity> {

	private static final Assembler<TipoMiembroDomain, TipoMiembroDTO, TipoMiembroEntity> INSTANCE_ASSEMBLER = new TipoMiembroAssembler();

	private TipoMiembroAssembler() {

	}

	public static final Assembler<TipoMiembroDomain, TipoMiembroDTO, TipoMiembroEntity> getInstance() {
		return INSTANCE_ASSEMBLER;
	}

	@Override
	public TipoMiembroDTO toDTOFromDomain(TipoMiembroDomain domain) {
		return TipoMiembroDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre())
				.setDescuentoDTO(DescuentoAssembler.getInstance().toDTOFromDomain(domain.getTipoDescuentoDTO()));
	}

	@Override
	public TipoMiembroDomain toDomainFromDTO(TipoMiembroDTO dto) {
		return new TipoMiembroDomain(dto.getIdentificador(), dto.getNombre(),
				DescuentoAssembler.getInstance().toDomainFromDTO(dto.getTipoDescuentoDTO()));
	}

	@Override
	public TipoMiembroEntity toEntityFromDomain(TipoMiembroDomain domain) {

		return new TipoMiembroEntity(domain.getIdentificador(), domain.getNombre(),
				DescuentoEntity.create(UtilUUID.DEFAULT_UUID, UtilNumber.ZERO,
						TipoDescuentoEntity.create(UtilUUID.DEFAULT_UUID, UtilText.EMPTY)));

	}

	@Override
	public TipoMiembroDomain toDomainFromEntity(TipoMiembroEntity entity) {

		return new TipoMiembroDomain(entity.getIdentificador(), entity.getNombre(),
				DescuentoAssembler.getInstance().toDomainFromEntity(entity.getDescuentoDTO()));

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
