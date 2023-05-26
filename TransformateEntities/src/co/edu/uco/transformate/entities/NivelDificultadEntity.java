package co.edu.uco.transformate.entities;


import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class NivelDificultadEntity {
	
	private UUID identificador;
	private String nombre;
	

	private static final NivelDificultadEntity DEFAULT_OBJECT = new NivelDificultadEntity();

	public static NivelDificultadEntity getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static NivelDificultadEntity create(UUID identificador, String nombre) {
		return new NivelDificultadEntity(identificador,nombre);
	}
	

	private NivelDificultadEntity(UUID identificador, String nombre) {
	
		setIdentificador(identificador);
		setNombre(nombre);
		

	}

	private NivelDificultadEntity() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		
		setNombre(UtilText.getDefaultValue());
		
	}

	public static NivelDificultadEntity create() {
		return new NivelDificultadEntity();
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

}
