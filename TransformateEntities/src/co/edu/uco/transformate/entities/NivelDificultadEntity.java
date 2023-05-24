package co.edu.uco.transformate.entities;

import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class NivelDificultadEntity {
	
	private UUID identificador;
	private String nombre;
	

	public NivelDificultadEntity(UUID identificador, String nombre) {
		super();
		setIdentificador(identificador);
		setNombre(nombre);
		

	}

	public NivelDificultadEntity() {
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

	public final NivelDificultadEntity setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public final String getNombre() {
		return nombre;
	}

	public final NivelDificultadEntity setNombre(String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
		return this;
	}

}
