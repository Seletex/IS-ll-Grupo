package co.edu.uco.transformate.dto;

import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class NivelDificultadDTO {
	
	private UUID identificador;
	private String nombre;
	

	public NivelDificultadDTO(UUID identificador, String nombre) {
		super();
		setIdentificador(identificador);
		setNombre(nombre);
		

	}

	public NivelDificultadDTO() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		
		setNombre(UtilText.getDefaultValue());
		
	}

	public static NivelDificultadDTO create() {
		return new NivelDificultadDTO();
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	public final NivelDificultadDTO setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public final String getNombre() {
		return nombre;
	}

	public final NivelDificultadDTO setNombre(String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
		return this;
	}

}
