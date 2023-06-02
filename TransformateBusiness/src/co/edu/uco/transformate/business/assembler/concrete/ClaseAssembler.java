package co.edu.uco.transformate.business.assembler.concrete;

import java.util.List;

import co.edu.uco.transformate.business.assembler.Assembler;
import co.edu.uco.transformate.business.domain.ClaseDomain;
import co.edu.uco.transformate.crosscutting.utils.UtilDate;
import co.edu.uco.transformate.crosscutting.utils.UtilNumber;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;
import co.edu.uco.transformate.dto.ClaseDTO;
import co.edu.uco.transformate.entities.ClaseEntity;
import co.edu.uco.transformate.entities.EntrenadorEntity;
import co.edu.uco.transformate.entities.GimnasioEntity;
import co.edu.uco.transformate.entities.TipoDocumentoEntity;

public class ClaseAssembler implements Assembler<ClaseDomain, ClaseDTO, ClaseEntity> {

	private static final Assembler<ClaseDomain, ClaseDTO, ClaseEntity> INSTANCE_ASSEMBLER = new ClaseAssembler();

	private ClaseAssembler() {

	}

	public static final Assembler<ClaseDomain, ClaseDTO, ClaseEntity> getInstance() {
		return INSTANCE_ASSEMBLER;
	}

	@Override
	public ClaseDTO toDTOFromDomain(ClaseDomain domain) {
		return ClaseDTO.create().setIdentificadorUuid(domain.getIdentificadorUuid()).setFechaDate(domain.getFechaDate())
				.setHoraInicioDate(domain.getHoraInicioDate()).setHoraFinDate(domain.getHoraFinDate())
				.setEntrenadorDTO(EntrenadorAssembler.getInstance().toDTOFromDomain(domain.getEntrenadorDTO()));
	}

	@Override
	public ClaseDomain toDomainFromDTO(ClaseDTO dto) {
		return new ClaseDomain(dto.getIdentificadorUuid(),

				dto.getFechaDate(), dto.getHoraInicioDate(), dto.getHoraFinDate(),
				EntrenadorAssembler.getInstance().toDomainFromDTO(dto.getEntrenadorDTO()));
	}

	@Override
	public ClaseEntity toEntityFromDomain(ClaseDomain domain) {
		return new ClaseEntity(domain.getIdentificadorUuid(), domain.getFechaDate(), domain.getHoraInicioDate(),
				domain.getHoraFinDate(),
				EntrenadorEntity.create(UtilUUID.DEFAULT_UUID,
						TipoDocumentoEntity.create(UtilUUID.DEFAULT_UUID, UtilText.EMPTY), UtilText.EMPTY,
						UtilText.EMPTY, UtilText.EMPTY, UtilText.EMPTY, UtilText.EMPTY, UtilNumber.ZERO,
						GimnasioEntity.create(UtilUUID.DEFAULT_UUID, UtilText.EMPTY, UtilText.EMPTY, UtilText.EMPTY,
								UtilText.EMPTY, UtilDate.DEFAULT_DATE_TIME, UtilDate.DEFAULT_DATE_TIME)));
	}

	@Override
	public ClaseDomain toDomainFromEntity(ClaseEntity entity) {
		return new ClaseDomain(entity.getIdentificadorUuid(),

				entity.getFechaDate(), entity.getHoraInicioDate(), entity.getHoraFinDate(),
				EntrenadorAssembler.getInstance().toDomainFromEntity(entity.getEntrenadorDTO()));
	}

	@Override
	public List<ClaseDomain> toDomainListFromEntityList(List<ClaseEntity> entityList) {
		return entityList.stream().map(this::toDomainFromEntity).toList();
	}

	@Override
	public List<ClaseDTO> toDTOListFromDomainList(List<ClaseDomain> domainList) {
		return domainList.stream().map(this::toDTOFromDomain).toList();
	}

}
