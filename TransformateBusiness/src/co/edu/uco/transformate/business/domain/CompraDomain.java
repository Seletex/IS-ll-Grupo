package co.edu.uco.transformate.business.domain;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilDate;
import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class CompraDomain {

	private static final CompraDomain DEFAULT_OBJECT = new CompraDomain();
	private UUID identificadorUuid;
	private ProductoDomain productoDomain;
	private TipoPagoDomain tipoPagoDomain;
	private LocalDate fechaDate;
	private EstadoPagoDomain estadoPagoDomain;

	public  CompraDomain(UUID identificadorUuid, ProductoDomain productoDomain, LocalDate fechaDate, EstadoPagoDomain estadoPagoDomain,
			TipoPagoDomain tipoPagoDomain) {
		setEstadoPagoDTO(estadoPagoDomain);
		setFechaDate(fechaDate);
		setIdentificadorUuid(identificadorUuid);
		setProductoDTO(productoDomain);
setTipoPagoDTO(tipoPagoDomain);
	}

	private CompraDomain() {
		setEstadoPagoDTO(EstadoPagoDomain.getDefaultObject());
		setFechaDate(UtilDate.DEFAULT_DATE);
		setIdentificadorUuid(UtilUUID.DEFAULT_UUID);
		setProductoDTO(ProductoDomain.create());
setTipoPagoDTO(TipoPagoDomain.getDefaultObject());
	}

	public static CompraDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}
	public CompraDomain create(UUID identificadorUuid, ProductoDomain productoDomain, LocalDate fechaDate, EstadoPagoDomain estadoPagoDomain,
			TipoPagoDomain tipoPagoDomain) {
		return new CompraDomain(identificadorUuid,productoDomain,fechaDate,estadoPagoDomain,tipoPagoDomain);
	}

	public final TipoPagoDomain getTipoPagoDTO() {
		return tipoPagoDomain;
	}

	public final void setTipoPagoDTO(TipoPagoDomain tipoPagoDomain) {
		this.tipoPagoDomain = UtilObject.getDefault(tipoPagoDomain, TipoPagoDomain.getDefaultObject());
		
	}

	public final UUID getIdentificadorUuid() {
		return identificadorUuid;
	}

	public final void setIdentificadorUuid(UUID identificadorUuid) {
		this.identificadorUuid = UtilUUID.getDefault(identificadorUuid);
		
	}

	public final ProductoDomain getProductoDTO() {
		return productoDomain;
	}

	public final void setProductoDTO(ProductoDomain productoDomain) {
		this.productoDomain = UtilObject.getDefault(productoDomain, ProductoDomain.create());
		
	}

	public final LocalDate getFechaDate() {
		return fechaDate;
	}

	public final void setFechaDate(LocalDate fechaDate) {
		this.fechaDate = UtilDate.getDefault(fechaDate);
	
	}

	public final EstadoPagoDomain getEstadoPagoDTO() {
		return estadoPagoDomain;
	}

	public final void setEstadoPagoDTO(EstadoPagoDomain estadoPagoDomain) {
		this.estadoPagoDomain = UtilObject.getDefault(estadoPagoDomain, EstadoPagoDomain.getDefaultObject());
		
	}

}
