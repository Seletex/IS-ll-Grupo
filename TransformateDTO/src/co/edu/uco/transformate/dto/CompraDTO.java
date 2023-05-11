package co.edu.uco.transformate.dto;

import java.sql.Date;
import java.util.UUID;

public class CompraDTO {
	
	private UUID identificadorUuid;
	private ProductoDTO productoDTO;
	private MiembroDTO miembroDTO;
	private Date fechaDate;
	private EstadoPagoDTO estadoPagoDTO;
	private MetodoPagoDTO metodoPagoDTO;
	
	
	public CompraDTO(UUID identificadorUuid, ProductoDTO productoDTO, MiembroDTO miembroDTO, Date fechaDate,
			EstadoPagoDTO estadoPagoDTO, MetodoPagoDTO metodoPagoDTO) {
		super();
		this.identificadorUuid = identificadorUuid;
		this.productoDTO = productoDTO;
		this.miembroDTO = miembroDTO;
		this.fechaDate = fechaDate;
		this.estadoPagoDTO = estadoPagoDTO;
		this.metodoPagoDTO = metodoPagoDTO;
	}


	public CompraDTO() {
		super();
	}
	
	public CompraDTO create() {
		return new CompraDTO();
	}
	
	

}
