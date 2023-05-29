package co.edu.uco.transformate.business.domain;

import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public final class EstadoPagoDomain {
	
	private UUID identificador;
	private String nombre;
	
	private static final EstadoPagoDomain DEFAULT_OBJECT = new EstadoPagoDomain();

	public static EstadoPagoDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static EstadoPagoDomain create(UUID identificador, String nombre) {
		return new EstadoPagoDomain(identificador,nombre);
	}

	public  EstadoPagoDomain(UUID identificador, String nombre) {
		
		setIdentificador(identificador);
		setNombre(nombre);
		

	}

	private EstadoPagoDomain() {
	
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
