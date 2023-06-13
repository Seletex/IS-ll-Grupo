package co.edu.uco.transformate.business.business.impl;


import java.util.List;


import co.edu.uco.transformate.business.assembler.Assembler;

import co.edu.uco.transformate.business.assembler.concrete.ObjetivoEntrenamientoAssembler;
import co.edu.uco.transformate.business.assembler.concrete.PruebaFisicaAssembler;
import co.edu.uco.transformate.business.assembler.concrete.TipoDocumentoAssembler;
import co.edu.uco.transformate.business.assembler.concrete.TipoMiembroAssembler;

import co.edu.uco.transformate.business.domain.MiembroDomain;

import co.edu.uco.transformate.crosscutting.utils.UtilDate;
import co.edu.uco.transformate.crosscutting.utils.UtilNumber;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

import co.edu.uco.transformate.dto.MiembroDTO;

import co.edu.uco.transformate.entities.DescuentoEntity;

import co.edu.uco.transformate.entities.MembresiaEntity;
import co.edu.uco.transformate.entities.MiembroEntity;
import co.edu.uco.transformate.entities.ObjetivoEntrenamientoEntity;
import co.edu.uco.transformate.entities.PruebaFisicaEntity;
import co.edu.uco.transformate.entities.TipoDescuentoEntity;
import co.edu.uco.transformate.entities.TipoDocumentoEntity;
import co.edu.uco.transformate.entities.TipoMembresiaEntity;
import co.edu.uco.transformate.entities.TipoMiembroEntity;

public class MiembroAssembler implements Assembler<MiembroDomain, MiembroDTO, MiembroEntity> {
	private static final Assembler<MiembroDomain, MiembroDTO, MiembroEntity> INSTANCE_ASSEMBLER = new MiembroAssembler();

	private MiembroAssembler() {

	}

	public static final Assembler<MiembroDomain, MiembroDTO, MiembroEntity> getInstance() {
		return INSTANCE_ASSEMBLER;
	}

	@Override
	public MiembroDTO toDTOFromDomain(MiembroDomain domain) {
		return MiembroDTO.create()
				.setMembresiaDTO(MembresiaAssembler.getInstance().toDTOFromDomain(domain.getMembresiaDTO()))
				.setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre())
				.setFechaNacimiento(domain.getFechaNacimiento()).setCorreo(domain.getCorreo())
				.setTelefono(domain.getTelefono())
				.setPrueba(PruebaFisicaAssembler.getInstance().toDTOFromDomain(domain.getPrueba()))
				.setObjetivo(ObjetivoEntrenamientoAssembler.getInstance().toDTOFromDomain(domain.getObjetivo()))
				.setTipoMiembroDTO(TipoMiembroAssembler.getInstance().toDTOFromDomain(domain.getTipoMiembroDTO()))
				.setTipoDocumentoDTO(
						TipoDocumentoAssembler.getInstance().toDTOFromDomain(domain.getTipoDocumentoDTO()));
	}

	@Override
	public MiembroDomain toDomainFromDTO(MiembroDTO dto) {
		return new MiembroDomain(MembresiaAssembler.getInstance().toDomainFromDTO(dto.getMembresiaDTO()),
				dto.getIdentificador(), dto.getNombre(),
				TipoDocumentoAssembler.getInstance().toDomainFromDTO(dto.getTipoDocumentoDTO()),
				dto.getIdentificacion(),

				dto.getFechaNacimiento(), dto.getCorreo(), dto.getTelefono(),
				PruebaFisicaAssembler.getInstance().toDomainFromDTO(dto.getPrueba()),

				ObjetivoEntrenamientoAssembler.getInstance().toDomainFromDTO(dto.getObjetivo()),
				TipoMiembroAssembler.getInstance().toDomainFromDTO(dto.getTipoMiembroDTO()));
	}

	@Override
	public MiembroEntity toEntityFromDomain(MiembroDomain domain) {
		return new MiembroEntity(
				MembresiaEntity.create(UtilUUID.DEFAULT_UUID,
						TipoMembresiaEntity.create(UtilUUID.DEFAULT_UUID, UtilText.EMPTY), UtilDate.DEFAULT_DATE,
						UtilDate.DEFAULT_DATE),
				domain.getIdentificador(), domain.getNombre(),
				TipoDocumentoEntity.create(UtilUUID.DEFAULT_UUID, UtilText.EMPTY), domain.getIdentificacion(),
				domain.getFechaNacimiento(), domain.getCorreo(), domain.getTelefono(),
				PruebaFisicaEntity.create(UtilUUID.DEFAULT_UUID, UtilText.EMPTY, UtilDate.DEFAULT_DATE_TIME),
				ObjetivoEntrenamientoEntity.create(UtilUUID.DEFAULT_UUID, UtilText.EMPTY),
				TipoMiembroEntity.create(UtilUUID.DEFAULT_UUID, UtilText.EMPTY,
						DescuentoEntity.create(UtilUUID.DEFAULT_UUID, UtilNumber.ZERO,
								TipoDescuentoEntity.create(UtilUUID.DEFAULT_UUID, UtilText.EMPTY))));
	}

	@Override
	public MiembroDomain toDomainFromEntity(MiembroEntity entity) {
		return new MiembroDomain(MembresiaAssembler.getInstance().toDomainFromEntity(entity.getMembresiaDTO()),
				entity.getIdentificador(),entity.getNombre(),
				TipoDocumentoAssembler.getInstance().toDomainFromEntity(entity.getTipoDocumentoDTO()),entity.getIdentificacion(),
				entity.getFechaNacimiento(),entity.getCorreo(),entity.getTelefono(),PruebaFisicaAssembler.getInstance().toDomainFromEntity(entity.getPrueba()),
				ObjetivoEntrenamientoAssembler.getInstance().toDomainFromEntity(entity.getObjetivo()),
				TipoMiembroAssembler.getInstance().toDomainFromEntity(entity.getTipoMiembroDTO())

				);
	}

	@Override
	public List<MiembroDomain> toDomainListFromEntityList(List<MiembroEntity> entityList) {
		return entityList.stream().map(this::toDomainFromEntity).toList();
	}

	@Override
	public List<MiembroDTO> toDTOListFromDomainList(List<MiembroDomain> domainList) {
		return domainList.stream().map(this::toDTOFromDomain).toList();
	}

}
