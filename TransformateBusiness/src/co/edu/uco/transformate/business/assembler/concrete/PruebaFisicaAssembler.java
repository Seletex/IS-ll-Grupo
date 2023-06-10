package co.edu.uco.transformate.business.assembler.concrete;

import java.util.List;

import co.edu.uco.transformate.business.assembler.Assembler;
import co.edu.uco.transformate.business.domain.PruebaFisicaDomain;

import co.edu.uco.transformate.dto.PruebaFisicaDTO;

import co.edu.uco.transformate.entities.PruebaFisicaEntity;


public class PruebaFisicaAssembler implements Assembler<PruebaFisicaDomain, PruebaFisicaDTO, PruebaFisicaEntity> {

	private static final Assembler<PruebaFisicaDomain, PruebaFisicaDTO, PruebaFisicaEntity> INSTANCE_ASSEMBLER = new PruebaFisicaAssembler();

	private PruebaFisicaAssembler() {

	}

	public static final Assembler<PruebaFisicaDomain, PruebaFisicaDTO, PruebaFisicaEntity> getInstance() {
		return INSTANCE_ASSEMBLER;
	}

	@Override
	public PruebaFisicaDTO toDTOFromDomain(PruebaFisicaDomain domain) {
		return PruebaFisicaDTO.create().setIdentificadorUuid(domain.getIdentificadorUuid())
				.setDescripcionString(domain.getDescripcionString()).setTiempoDateTime(domain.getTiempoDateTime());
	}

	@Override
	public PruebaFisicaDomain toDomainFromDTO(PruebaFisicaDTO dto) {
		return new PruebaFisicaDomain(dto.getIdentificadorUuid(), dto.getDescripcionString(),dto.getTiempoDateTime()
				);
	}

	@Override
	public PruebaFisicaEntity toEntityFromDomain(PruebaFisicaDomain domain) {
		return new PruebaFisicaEntity(domain.getIdentificadorUuid(), domain.getDescripcionString(),domain.getTiempoDateTime()
				);
	}

	@Override
	public PruebaFisicaDomain toDomainFromEntity(PruebaFisicaEntity entity) {
		return new PruebaFisicaDomain(entity.getIdentificadorUuid(), entity.getDescripcionString(),entity.getTiempoDateTime()
				);
	}

	@Override
	public List<PruebaFisicaDomain> toDomainListFromEntityList(List<PruebaFisicaEntity> entityList) {
		return entityList.stream().map(this::toDomainFromEntity).toList();
	}

	@Override
	public List<PruebaFisicaDTO> toDTOListFromDomainList(List<PruebaFisicaDomain> domainList) {
		return domainList.stream().map(this::toDTOFromDomain).toList();
	}

}
