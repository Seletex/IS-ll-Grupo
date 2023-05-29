package co.edu.uco.transformate.business.domain;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilDate;
import co.edu.uco.transformate.crosscutting.utils.UtilNumber;
import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class FacturaDomain {

	private UUID identificador;
	private LocalDate fecha;
	private int total;
	private MiembroDomain miembroDTO;
	private ProductoDomain productoDTO;
	
	private static final FacturaDomain DEFAULT_OBJECT = new FacturaDomain();

	public static FacturaDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static FacturaDomain create(UUID identificador, LocalDate fecha, int total, MiembroDomain miembroDTO,
			ProductoDomain productoDTO) {
		return new FacturaDomain(identificador,fecha,total,miembroDTO,productoDTO);
	}


	public  FacturaDomain(UUID identificador, LocalDate fecha, int total, MiembroDomain miembroDTO,
			ProductoDomain productoDTO) {
		setFecha(fecha);
		setIdentificador(identificador);
		setMiembroDTO(miembroDTO);
		setProductoDTO(productoDTO);
		setTotal(total);
	}

	private FacturaDomain() {
		setFecha(UtilDate.DEFAULT_DATE);
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setMiembroDTO(MiembroDomain.getDefaultObject());
		setProductoDTO(ProductoDomain.getDefaultObject());
		setTotal(UtilNumber.getDefaultNumber());
	}

	

	public UUID getIdentificador() {
		return identificador;
	}

	private void setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
	}

	public LocalDate getFecha() {
		return fecha;
	}

	private void setFecha(LocalDate fecha) {
		this.fecha = UtilDate.getDefault(fecha);
	}

	public int getTotal() {
		return total;
	}

	private void setTotal(int total) {
		this.total = UtilNumber.getDefaultNumber(total);
	}

	public MiembroDomain getMiembroDTO() {
		return miembroDTO;
	}

	private void setMiembroDTO(MiembroDomain miembroDTO) {
		this.miembroDTO = UtilObject.getDefault(miembroDTO, MiembroDomain.getDefaultObject());
	}

	public ProductoDomain getProductoDTO() {
		return productoDTO;
	}

	private void setProductoDTO(ProductoDomain productoDTO) {
		this.productoDTO = UtilObject.getDefault(productoDTO, ProductoDomain.getDefaultObject());
	}

}
