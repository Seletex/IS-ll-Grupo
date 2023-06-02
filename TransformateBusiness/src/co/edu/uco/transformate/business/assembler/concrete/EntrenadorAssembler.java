package co.edu.uco.transformate.business.assembler.concrete;

import java.util.List;

import co.edu.uco.transformate.business.assembler.Assembler;

import co.edu.uco.transformate.business.domain.EntrenadorDomain;
import co.edu.uco.transformate.crosscutting.utils.UtilDate;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

import co.edu.uco.transformate.dto.EntrenadorDTO;

import co.edu.uco.transformate.entities.EntrenadorEntity;
import co.edu.uco.transformate.entities.GimnasioEntity;

import co.edu.uco.transformate.entities.TipoDocumentoEntity;

public class EntrenadorAssembler implements Assembler<EntrenadorDomain, EntrenadorDTO, EntrenadorEntity> {

	private static final Assembler<EntrenadorDomain, EntrenadorDTO, EntrenadorEntity> INSTANCE_ASSEMBLER = new EntrenadorAssembler();

	private EntrenadorAssembler() {

	}

	public static final Assembler<EntrenadorDomain, EntrenadorDTO, EntrenadorEntity> getInstance() {
		return INSTANCE_ASSEMBLER;
	}

	@Override
	public EntrenadorDTO toDTOFromDomain(EntrenadorDomain domain) {
		return EntrenadorDTO.create().setIdentificador(domain.getIdentificador())
				.setTipoDocumentoDTO(TipoDocumentoAssembler.getInstance().toDTOFromDomain(domain.getTipoDocumentoDTO()))
				.setIdentificacion(domain.getIdentificacion()).setNombre(domain.getNombre())
				.setUsuario(domain.getUsuario()).setConstraseña(domain.getConstraseña())
				.setTelefono(domain.getTelefono()).setSalario(domain.getSalario())
				.setGimnasioDTO(GimnasioAssembler.getInstance().toDTOFromDomain(domain.getGimnasioDTO()));
	}

	@Override
	public EntrenadorDomain toDomainFromDTO(EntrenadorDTO dto) {
		return new EntrenadorDomain(dto.getIdentificador(),
				TipoDocumentoAssembler.getInstance().toDomainFromDTO(dto.getTipoDocumentoDTO()),
				dto.getIdentificacion(), dto.getNombre(), dto.getUsuario(), dto.getConstraseña(), dto.getTelefono(),
				dto.getSalario(), GimnasioAssembler.getInstance().toDomainFromDTO(dto.getGimnasioDTO()));
	}

	@Override
	public EntrenadorEntity toEntityFromDomain(EntrenadorDomain domain) {
		return new EntrenadorEntity(domain.getIdentificador(),
				TipoDocumentoEntity.create(UtilUUID.genereteNewUUID(), UtilText.EMPTY), domain.getIdentificacion(),
				domain.getNombre(), domain.getUsuario(), domain.getConstraseña(), domain.getTelefono(),
				domain.getSalario(), GimnasioEntity.create(UtilUUID.genereteNewUUID(), UtilText.EMPTY, UtilText.EMPTY,
						UtilText.EMPTY, UtilText.EMPTY, UtilDate.DEFAULT_DATE_TIME, UtilDate.DEFAULT_DATE_TIME));
	}

	@Override
	public EntrenadorDomain toDomainFromEntity(EntrenadorEntity entity) {
		return new EntrenadorDomain(entity.getIdentificador(),
				TipoDocumentoAssembler.getInstance().toDomainFromEntity(entity.getTipoDocumentoDTO()),
				entity.getIdentificacion(), entity.getNombre(), entity.getUsuario(), entity.getConstraseña(),
				entity.getTelefono(), entity.getSalario(),
				GimnasioAssembler.getInstance().toDomainFromEntity(entity.getGimnasioDTO()));
	}

	@Override
	public List<EntrenadorDomain> toDomainListFromEntityList(List<EntrenadorEntity> entityList) {
		return entityList.stream().map(this::toDomainFromEntity).toList();
	}

	@Override
	public List<EntrenadorDTO> toDTOListFromDomainList(List<EntrenadorDomain> domainList) {
		return domainList.stream().map(this::toDTOFromDomain).toList();
	}

}
