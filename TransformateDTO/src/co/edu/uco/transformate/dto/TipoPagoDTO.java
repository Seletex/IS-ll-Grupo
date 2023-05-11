package co.edu.uco.transformate.dto;

import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class TipoPagoDTO {
	
	private UUID identificador;
	private String nombre;
	

	public TipoPagoDTO(UUID identificador, String nombre) {
		super();
		setIdentificador(identificador);
		setNombre(nombre);
		

	}

	public TipoPagoDTO() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		
		setNombre(UtilText.getDefaultValue());
		
	}

	public static TipoPagoDTO create() {
		return new TipoPagoDTO();
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	public final TipoPagoDTO setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public final String getNombre() {
		return nombre;
	}

	public final TipoPagoDTO setNombre(String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
		return this;
	}

	

	

}
