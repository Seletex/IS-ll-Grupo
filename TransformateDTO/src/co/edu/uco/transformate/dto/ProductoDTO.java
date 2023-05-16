package co.edu.uco.transformate.dto;

import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilNumber;

import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class ProductoDTO {

	private UUID identificador;
	private String nombre;
	private String descripcion;
	private int cantidad;

	public ProductoDTO(UUID identificador, String nombre, String descripcion, int cantidad) {
	
		setIdentificador(identificador);
		setNombre(nombre);
		setDescripcion(descripcion);
		setCantidad(cantidad);

	}

	
	public ProductoDTO() {
	
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setCantidad(UtilNumber.ZERO);
		setNombre(UtilText.getDefaultValue());
		setDescripcion(UtilText.EMPTY);
	}

	public static ProductoDTO create() {
		return new ProductoDTO();
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	public final ProductoDTO setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public final String getNombre() {
		return nombre;
	}

	public final ProductoDTO setNombre(String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
		return this;
	}

	public final String getDescripcion() {
		return descripcion;
	}

	public final ProductoDTO setDescripcion(String descripcion) {
		this.descripcion = UtilText.getUtilText().applyTrim(descripcion);
		return this;
	}

	public final int getCantidad() {
		return cantidad;
	}

	public final ProductoDTO setCantidad(int cantidad) {
		this.cantidad = UtilNumber.getDefaultNumber(cantidad);
		return this;
	}

	
}
