package co.edu.uco.transformate.entities;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilDate;
import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class CompraEntity {

	private static final CompraEntity DEFAULT_OBJECT = new CompraEntity();
	private UUID identificadorUuid;
	private ProductoEntity productoEntity;
	private TipoPagoEntity tipoPagoEntity;
	private LocalDate fechaDate;
	private EstadoPagoEntity estadoPagoEntity;

	private CompraEntity(UUID identificadorUuid, ProductoEntity productoEntity, LocalDate fechaDate, EstadoPagoEntity estadoPagoEntity,
			TipoPagoEntity tipoPagoEntity) {
		setEstadoPagoDTO(estadoPagoEntity);
		setFechaDate(fechaDate);
		setIdentificadorUuid(identificadorUuid);
		setProductoDTO(productoEntity);
setTipoPagoDTO(tipoPagoEntity);
	}

	private CompraEntity() {
		setEstadoPagoDTO(EstadoPagoEntity.create());
		setFechaDate(UtilDate.DEFAULT_DATE);
		setIdentificadorUuid(UtilUUID.DEFAULT_UUID);
		setProductoDTO(ProductoEntity.create());
setTipoPagoDTO(TipoPagoEntity.create());
	}

	public static CompraEntity getDefaultObject() {
		return DEFAULT_OBJECT;
	}
	public CompraEntity create(UUID identificadorUuid, ProductoEntity productoEntity, LocalDate fechaDate, EstadoPagoEntity estadoPagoEntity,
			TipoPagoEntity tipoPagoEntity) {
		return new CompraEntity(identificadorUuid,productoEntity,fechaDate,estadoPagoEntity,tipoPagoEntity);
	}

	public final TipoPagoEntity getTipoPagoDTO() {
		return tipoPagoEntity;
	}

	public final void setTipoPagoDTO(TipoPagoEntity tipoPagoEntity) {
		this.tipoPagoEntity = UtilObject.getDefault(tipoPagoEntity, TipoPagoEntity.create());
		
	}

	public final UUID getIdentificadorUuid() {
		return identificadorUuid;
	}

	public final void setIdentificadorUuid(UUID identificadorUuid) {
		this.identificadorUuid = UtilUUID.getDefault(identificadorUuid);
		
	}

	public final ProductoEntity getProductoDTO() {
		return productoEntity;
	}

	public final void setProductoDTO(ProductoEntity productoEntity) {
		this.productoEntity = UtilObject.getDefault(productoEntity, ProductoEntity.create());
		
	}

	public final LocalDate getFechaDate() {
		return fechaDate;
	}

	public final void setFechaDate(LocalDate fechaDate) {
		this.fechaDate = UtilDate.getDefault(fechaDate);
	
	}

	public final EstadoPagoEntity getEstadoPagoDTO() {
		return estadoPagoEntity;
	}

	public final void setEstadoPagoDTO(EstadoPagoEntity estadoPagoEntity) {
		this.estadoPagoEntity = UtilObject.getDefault(estadoPagoEntity, EstadoPagoEntity.create());
		
	}

}
