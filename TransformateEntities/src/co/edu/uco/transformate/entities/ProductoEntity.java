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
	

	private static final ProductoEntity DEFAULT_OBJECT = new ProductoEntity();

	public static ProductoEntity getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static ProductoEntity create(UUID identificador, String nombre, String descripcion, int cantidad
			) {
		return new ProductoEntity(identificador,nombre,descripcion,cantidad);
	}

	public ProductoEntity(UUID identificador, String nombre, String descripcion, int cantidad) {
	
		setIdentificador(identificador);
		setNombre(nombre);
		setDescripcion(descripcion);
		setCantidad(cantidad);

	}

	
	private ProductoEntity() {
	
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

	private final void setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
	
	}

	public final String getNombre() {
		return nombre;
	}

	private final void setNombre(String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);

	}

	public final String getDescripcion() {
		return descripcion;
	}

	private final void setDescripcion(String descripcion) {
		this.descripcion = UtilText.getUtilText().applyTrim(descripcion);
		
	}

	public final int getCantidad() {
		return cantidad;
	}

	private final void setCantidad(int cantidad) {
		this.cantidad = UtilNumber.getDefaultNumber(cantidad);
		
	}

	
}
