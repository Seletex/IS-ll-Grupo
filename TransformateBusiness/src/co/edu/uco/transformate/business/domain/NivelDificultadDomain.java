package co.edu.uco.transformate.business.domain;


import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class NivelDificultadDomain {
	
	private UUID identificador;
	private String nombre;
	

	private static final NivelDificultadDomain DEFAULT_OBJECT = new NivelDificultadDomain();

	public static NivelDificultadDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static NivelDificultadDomain create(UUID identificador, String nombre) {
		return new NivelDificultadDomain(identificador,nombre);
	}
	

	public NivelDificultadDomain(UUID identificador, String nombre) {
	
		setIdentificador(identificador);
		setNombre(nombre);
		

	}

	private NivelDificultadDomain() {
	
		setIdentificador(UtilUUID.DEFAULT_UUID);
		
		setNombre(UtilText.getDefaultValue());
		
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
