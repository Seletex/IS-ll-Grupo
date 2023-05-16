package co.edu.uco.transformate.dto;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilDate;
import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class CompraDTO {

	private UUID identificadorUuid;
	private ProductoDTO productoDTO;
	private TipoPagoDTO tipoPagoDTO;
	private LocalDate fechaDate;
	private EstadoPagoDTO estadoPagoDTO;

	public CompraDTO(UUID identificadorUuid, ProductoDTO productoDTO, LocalDate fechaDate, EstadoPagoDTO estadoPagoDTO,
			TipoPagoDTO tipoPagoDTO) {
		setEstadoPagoDTO(estadoPagoDTO);
		setFechaDate(fechaDate);
		setIdentificadorUuid(identificadorUuid);
		setProductoDTO(productoDTO);
setTipoPagoDTO(tipoPagoDTO);
	}

	public CompraDTO() {
		setEstadoPagoDTO(EstadoPagoDTO.create());
		setFechaDate(UtilDate.DEFAULT_DATE);
		setIdentificadorUuid(UtilUUID.DEFAULT_UUID);
		setProductoDTO(ProductoDTO.create());
setTipoPagoDTO(TipoPagoDTO.create());
	}

	public CompraDTO create() {
		return new CompraDTO();
	}

	public final TipoPagoDTO getTipoPagoDTO() {
		return tipoPagoDTO;
	}

	public final CompraDTO setTipoPagoDTO(TipoPagoDTO tipoPagoDTO) {
		this.tipoPagoDTO = UtilObject.getDefault(tipoPagoDTO, TipoPagoDTO.create());
		return this;
	}

	public final UUID getIdentificadorUuid() {
		return identificadorUuid;
	}

	public final CompraDTO setIdentificadorUuid(UUID identificadorUuid) {
		this.identificadorUuid = UtilUUID.getDefault(identificadorUuid);
		return this;
	}

	public final ProductoDTO getProductoDTO() {
		return productoDTO;
	}

	public final CompraDTO setProductoDTO(ProductoDTO productoDTO) {
		this.productoDTO = UtilObject.getDefault(productoDTO, ProductoDTO.create());
		return this;
	}

	public final LocalDate getFechaDate() {
		return fechaDate;
	}

	public final CompraDTO setFechaDate(LocalDate fechaDate) {
		this.fechaDate = UtilDate.getDefault(fechaDate);
		return this;
	}

	public final EstadoPagoDTO getEstadoPagoDTO() {
		return estadoPagoDTO;
	}

	public final CompraDTO setEstadoPagoDTO(EstadoPagoDTO estadoPagoDTO) {
		this.estadoPagoDTO = UtilObject.getDefault(estadoPagoDTO, EstadoPagoDTO.create());
		return this;
	}

}
