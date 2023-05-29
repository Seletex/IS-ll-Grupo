package co.edu.uco.transformate.entities;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilDate;
import co.edu.uco.transformate.crosscutting.utils.UtilNumber;
import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class FacturaEntity {

	private UUID identificador;
	private LocalDate fecha;
	private int total;
	private MiembroEntity miembroDTO;
	private ProductoEntity productoDTO;
	
	private static final FacturaEntity DEFAULT_OBJECT = new FacturaEntity();

	public static FacturaEntity getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static FacturaEntity create(UUID identificador, LocalDate fecha, int total, MiembroEntity miembroDTO,
			ProductoEntity productoDTO) {
		return new FacturaEntity(identificador,fecha,total,miembroDTO,productoDTO);
	}


	public  FacturaEntity(UUID identificador, LocalDate fecha, int total, MiembroEntity miembroDTO,
			ProductoEntity productoDTO) {
		setFecha(fecha);
		setIdentificador(identificador);
		setMiembroDTO(miembroDTO);
		setProductoDTO(productoDTO);
		setTotal(total);
	}

	private FacturaEntity() {
		setFecha(UtilDate.DEFAULT_DATE);
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setMiembroDTO(MiembroEntity.getDefaultObject());
		setProductoDTO(ProductoEntity.getDefaultObject());
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

	public MiembroEntity getMiembroDTO() {
		return miembroDTO;
	}

	private void setMiembroDTO(MiembroEntity miembroDTO) {
		this.miembroDTO = UtilObject.getDefault(miembroDTO, MiembroEntity.getDefaultObject());
	}

	public ProductoEntity getProductoDTO() {
		return productoDTO;
	}

	private void setProductoDTO(ProductoEntity productoDTO) {
		this.productoDTO = UtilObject.getDefault(productoDTO, ProductoEntity.getDefaultObject());
	}

}
