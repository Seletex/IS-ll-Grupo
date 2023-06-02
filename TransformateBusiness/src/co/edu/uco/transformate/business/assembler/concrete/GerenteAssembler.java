package co.edu.uco.transformate.business.assembler.concrete;

import java.util.List;

import co.edu.uco.transformate.business.assembler.Assembler;

import co.edu.uco.transformate.business.domain.GerenteDomain;
import co.edu.uco.transformate.crosscutting.utils.UtilDate;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

import co.edu.uco.transformate.dto.GerenteDTO;

import co.edu.uco.transformate.entities.GerenteEntity;
import co.edu.uco.transformate.entities.GimnasioEntity;
import co.edu.uco.transformate.entities.TipoDocumentoEntity;

public class GerenteAssembler implements Assembler<GerenteDomain, GerenteDTO, GerenteEntity>{

	private static final Assembler<GerenteDomain, GerenteDTO, GerenteEntity> INSTANCE_ASSEMBLER = new GerenteAssembler();

	private GerenteAssembler() {

	}

	public static final Assembler<GerenteDomain, GerenteDTO, GerenteEntity> getInstance() {
		return INSTANCE_ASSEMBLER;
	}
	
	@Override
	public GerenteDTO toDTOFromDomain(GerenteDomain domain) {
		return GerenteDTO.create().setIdentificador(domain.getIdentificador())
				.setTipoDocumentoDTO(TipoDocumentoAssembler.getInstance().toDTOFromDomain(domain.getTipoDocumentoDTO()))
				.setIdentificacion(domain.getIdentificacion()).setNombre(domain.getNombre())
				.setUsuario(domain.getUsuario()).setConstraseña(domain.getConstraseña())
				.setTelefono(domain.getTelefono()).setSalario(domain.getSalario())
				.setGimnasioDTO(GimnasioAssembler.getInstance().toDTOFromDomain(domain.getGimnasioDTO()));
	}

	@Override
	public GerenteDomain toDomainFromDTO(GerenteDTO dto) {
		return new GerenteDomain(dto.getIdentificador(),
				TipoDocumentoAssembler.getInstance().toDomainFromDTO(dto.getTipoDocumentoDTO()),
				dto.getIdentificacion(), dto.getNombre(), dto.getUsuario(), dto.getConstraseña(), dto.getTelefono(),
				dto.getSalario(), GimnasioAssembler.getInstance().toDomainFromDTO(dto.getGimnasioDTO()));
	}

	@Override
	public GerenteEntity toEntityFromDomain(GerenteDomain domain) {
		return new GerenteEntity(domain.getIdentificador(),
				TipoDocumentoEntity.create(UtilUUID.DEFAULT_UUID, UtilText.EMPTY), domain.getIdentificacion(),
				domain.getNombre(), domain.getUsuario(), domain.getConstraseña(), domain.getTelefono(),
				domain.getSalario(), GimnasioEntity.create(UtilUUID.DEFAULT_UUID, UtilText.EMPTY, UtilText.EMPTY,
						UtilText.EMPTY, UtilText.EMPTY, UtilDate.DEFAULT_DATE_TIME, UtilDate.DEFAULT_DATE_TIME));
	}

	@Override
	public GerenteDomain toDomainFromEntity(GerenteEntity entity) {
		return new GerenteDomain(entity.getIdentificador(),
				TipoDocumentoAssembler.getInstance().toDomainFromEntity(entity.getTipoDocumentoDTO()),
				entity.getIdentificacion(), entity.getNombre(), entity.getUsuario(), entity.getConstraseña(),
				entity.getTelefono(), entity.getSalario(),
				GimnasioAssembler.getInstance().toDomainFromEntity(entity.getGimnasioDTO()));
	}

	@Override
	public List<GerenteDomain> toDomainListFromEntityList(List<GerenteEntity> entityList) {
		return entityList.stream().map(this::toDomainFromEntity).toList();
	}

	@Override
	public List<GerenteDTO> toDTOListFromDomainList(List<GerenteDomain> domainList) {
		return domainList.stream().map(this::toDTOFromDomain).toList();
	}

}
