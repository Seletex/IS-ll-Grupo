package co.edu.uco.transformate.dto;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilDate;
import co.edu.uco.transformate.crosscutting.utils.UtilNumber;
import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class FacturaDTO {
	
	private UUID identificador;
	private LocalDate fecha;
	private int total;
	private MiembroDTO miembroDTO;
	private ProductoDTO productoDTO;
	public FacturaDTO(UUID identificador, LocalDate fecha, int total, MiembroDTO miembroDTO, ProductoDTO productoDTO) {
		setFecha(fecha);
		setIdentificador(identificador);
		setMiembroDTO(miembroDTO);
		setProductoDTO(productoDTO);
		setTotal(total);
	}
	public FacturaDTO() {
		setFecha(UtilDate.DEFAULT_DATE);
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setMiembroDTO(MiembroDTO.create());
		setProductoDTO(ProductoDTO.create());
		setTotal(UtilNumber.getDefaultNumber());
	}
	
	public static FacturaDTO create() {
		return new FacturaDTO();
	}
	public UUID getIdentificador() {
		return identificador;
	}
	public FacturaDTO setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);return this;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public FacturaDTO setFecha(LocalDate fecha) {
		this.fecha = UtilDate.getDefault(fecha);return this;
	}
	public int getTotal() {
		return total;
	}
	public FacturaDTO setTotal(int total) {
		this.total = UtilNumber.getDefaultNumber(total);return this;
	}
	public MiembroDTO getMiembroDTO() {
		return miembroDTO;
	}
	public FacturaDTO setMiembroDTO(MiembroDTO miembroDTO) {
		this.miembroDTO = UtilObject.getDefault(miembroDTO, MiembroDTO.create());return this;
	}
	public ProductoDTO getProductoDTO() {
		return productoDTO;
	}
	public FacturaDTO setProductoDTO(ProductoDTO productoDTO) {
		this.productoDTO = UtilObject.getDefault(productoDTO, ProductoDTO.create());return this;
	}
	

}
