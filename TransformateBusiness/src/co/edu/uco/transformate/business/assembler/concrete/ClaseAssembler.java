package co.edu.uco.transformate.business.assembler.concrete;

import java.util.List;

import co.edu.uco.publiuco.dto.EstadoTipoRelacionInstitucionDTO;
import co.edu.uco.transformate.business.assembler.Assembler;
import co.edu.uco.transformate.business.domain.ClaseDomain;
import co.edu.uco.transformate.dto.ClaseDTO;
import co.edu.uco.transformate.entities.ClaseEntity;

public class ClaseAssembler implements Assembler<ClaseDomain, ClaseDTO,ClaseEntity>{

	private static final Assembler<ClaseDomain, ClaseDTO,ClaseEntity> INSTANCE_ASSEMBLER = new ClaseAssembler();

	private ClaseAssembler() {

	}
	public static final Assembler<ClaseDomain, ClaseDTO,ClaseEntity> getInstance(){
		return INSTANCE_ASSEMBLER;
	}
	@Override
	public ClaseDTO toDTOFromDomain(ClaseDomain domain) {
		return ClaseDTO.create().setIdentificadorUuid(domain.getIdentificadorUuid()).setFechaDate(domain.getFechaDate()).setHoraInicioDate(domain.getHoraInicioDate())
				.setHoraFinDate(domain.getHoraFinDate()).setEntrenadorDTO(domain.getEntrenadorDTO());
	}

	@Override
	public ClaseDomain toDomainFromDTO(ClaseDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClaseEntity toEntityFromDomain(ClaseDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClaseDomain toDomainFromEntity(ClaseEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClaseDomain> toDomainListFromEntityList(List<ClaseEntity> entityList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClaseDTO> toDTOListFromDomainList(List<ClaseDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}

}
