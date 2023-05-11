package co.edu.uco.transformate.dto;

import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class TipoRutinaDTO {
	
	private UUID identificador;
	private String nombre;
	private String descripcion;
	
	

	public TipoRutinaDTO(UUID identificador, String nombre, String descripcion) {
		super();
		setIdentificador(identificador);
		setNombre(nombre);
		setDescripcion(descripcion);
		

	}

	public TipoRutinaDTO() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setDescripcion(UtilText.EMPTY);
		setNombre(UtilText.getDefaultValue());
		
	}

	public final String getDescripcion() {
		return descripcion;
	}

	public final TipoRutinaDTO setDescripcion(String descripcion) {
		this.descripcion = UtilText.getUtilText().applyTrim(descripcion);
		return this;
	}

	
	public static TipoRutinaDTO create() {
		return new TipoRutinaDTO();
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	public final TipoRutinaDTO setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public final String getNombre() {
		return nombre;
	}

	public final TipoRutinaDTO setNombre(String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
		return this;
	}

}
