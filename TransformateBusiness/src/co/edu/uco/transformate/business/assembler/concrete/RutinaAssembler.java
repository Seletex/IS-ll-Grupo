package co.edu.uco.transformate.business.assembler.concrete;

import java.util.List;

import co.edu.uco.transformate.business.assembler.Assembler;
import co.edu.uco.transformate.business.domain.RutinaDomain;

import co.edu.uco.transformate.dto.RutinaDTO;
import co.edu.uco.transformate.entities.RutinaEntity;

public class RutinaAssembler implements Assembler<RutinaDomain, RutinaDTO, RutinaEntity> {

	private static final Assembler<RutinaDomain, RutinaDTO, RutinaEntity> INSTANCE_ASSEMBLER = new RutinaAssembler();

	private RutinaAssembler() {

	}

	public static final Assembler<RutinaDomain, RutinaDTO, RutinaEntity> getInstance() {
		return INSTANCE_ASSEMBLER;
	}

	@Override
	public RutinaDTO toDTOFromDomain(RutinaDomain domain) {
		return null;
	}

	@Override
	public RutinaDomain toDomainFromDTO(RutinaDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RutinaEntity toEntityFromDomain(RutinaDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RutinaDomain toDomainFromEntity(RutinaEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RutinaDomain> toDomainListFromEntityList(List<RutinaEntity> entityList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RutinaDTO> toDTOListFromDomainList(List<RutinaDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}

}
