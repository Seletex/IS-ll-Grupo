package co.edu.uco.transformate.entities;

import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilNumber;

import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class ProductoEntity {

	private UUID identificador;
	private String nombre;
	private String descripcion;
	private int cantidad;

	public ProductoEntity(UUID identificador, String nombre, String descripcion, int cantidad) {
	
		setIdentificador(identificador);
		setNombre(nombre);
		setDescripcion(descripcion);
		setCantidad(cantidad);

	}

	
	public ProductoEntity() {
	
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setCantidad(UtilNumber.ZERO);
		setNombre(UtilText.getDefaultValue());
		setDescripcion(UtilText.EMPTY);
	}

	public static ProductoEntity create() {
		return new ProductoEntity();
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	public final ProductoEntity setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public final String getNombre() {
		return nombre;
	}

	public final ProductoEntity setNombre(String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
		return this;
	}

	public final String getDescripcion() {
		return descripcion;
	}

	public final ProductoEntity setDescripcion(String descripcion) {
		this.descripcion = UtilText.getUtilText().applyTrim(descripcion);
		return this;
	}

	public final int getCantidad() {
		return cantidad;
	}

	public final ProductoEntity setCantidad(int cantidad) {
		this.cantidad = UtilNumber.getDefaultNumber(cantidad);
		return this;
	}

	
}
