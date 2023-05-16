package co.edu.uco.transformate.dto;

import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public final class EstadoPagoDTO {
	
	private UUID identificador;
	private String nombre;
	

	public EstadoPagoDTO(UUID identificador, String nombre) {
		
		setIdentificador(identificador);
		setNombre(nombre);
		

	}

	public EstadoPagoDTO() {
	
		setIdentificador(UtilUUID.DEFAULT_UUID);
		
		setNombre(UtilText.getDefaultValue());
		
	}

	public static EstadoPagoDTO create() {
		return new EstadoPagoDTO();
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	public final EstadoPagoDTO setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public final String getNombre() {
		return nombre;
	}

	public final EstadoPagoDTO setNombre(String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
		return this;
	}

}
