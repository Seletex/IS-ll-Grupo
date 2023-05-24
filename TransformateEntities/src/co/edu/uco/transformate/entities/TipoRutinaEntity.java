package co.edu.uco.transformate.entities;

import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class TipoRutinaEntity {
	
	private UUID identificador;
	private String nombre;
	private String descripcion;
	
	

	public TipoRutinaEntity(UUID identificador, String nombre, String descripcion) {
		super();
		setIdentificador(identificador);
		setNombre(nombre);
		setDescripcion(descripcion);
		

	}

	public TipoRutinaEntity() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setDescripcion(UtilText.EMPTY);
		setNombre(UtilText.getDefaultValue());
		
	}

	public final String getDescripcion() {
		return descripcion;
	}

	public final TipoRutinaEntity setDescripcion(String descripcion) {
		this.descripcion = UtilText.getUtilText().applyTrim(descripcion);
		return this;
	}

	
	public static TipoRutinaEntity create() {
		return new TipoRutinaEntity();
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	public final TipoRutinaEntity setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public final String getNombre() {
		return nombre;
	}

	public final TipoRutinaEntity setNombre(String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
		return this;
	}

}
