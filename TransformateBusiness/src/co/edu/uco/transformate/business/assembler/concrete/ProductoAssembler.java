package co.edu.uco.transformate.business.assembler.concrete;

import java.util.List;

import co.edu.uco.transformate.business.assembler.Assembler;

import co.edu.uco.transformate.business.domain.ProductoDomain;

import co.edu.uco.transformate.dto.ProductoDTO;

import co.edu.uco.transformate.entities.ProductoEntity;


public class ProductoAssembler implements Assembler<ProductoDomain,ProductoDTO, ProductoEntity>{

	private static final Assembler<ProductoDomain,ProductoDTO, ProductoEntity> INSTANCE_ASSEMBLER = new ProductoAssembler();

	private ProductoAssembler() {

	}

	public static final Assembler<ProductoDomain,ProductoDTO, ProductoEntity> getInstance() {
		return INSTANCE_ASSEMBLER;
	}
	@Override
	public ProductoDTO toDTOFromDomain(ProductoDomain domain) {
		return ProductoDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre())
				.setDescripcion(domain.getDescripcion()).setCantidad(domain.getCantidad())
				;
	}

	@Override
	public ProductoDomain toDomainFromDTO(ProductoDTO dto) {
		return new ProductoDomain(dto.getIdentificador(),

				dto.getNombre(), dto.getDescripcion(), dto.getCantidad()
				);
	}

	@Override
	public ProductoEntity toEntityFromDomain(ProductoDomain domain) {
		return new ProductoEntity(domain.getIdentificador(), domain.getNombre(), domain.getDescripcion(),
				domain.getCantidad()
				);
	}

	@Override
	public ProductoDomain toDomainFromEntity(ProductoEntity entity) {
		return new ProductoDomain(entity.getIdentificador(),

				entity.getNombre(), entity.getDescripcion(), entity.getCantidad());
	}

	@Override
	public List<ProductoDomain> toDomainListFromEntityList(List<ProductoEntity> entityList) {
		return entityList.stream().map(this::toDomainFromEntity).toList();
	}

	@Override
	public List<ProductoDTO> toDTOListFromDomainList(List<ProductoDomain> domainList) {
		return domainList.stream().map(this::toDTOFromDomain).toList();
	}

}
