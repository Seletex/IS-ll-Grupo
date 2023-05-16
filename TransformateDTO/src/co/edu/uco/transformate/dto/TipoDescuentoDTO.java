package co.edu.uco.transformate.dto;

import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class TipoDescuentoDTO {
	
	private UUID identificador;
	private String nombre;
	

	public TipoDescuentoDTO(UUID identificador, String nombre) {
		super();
		setIdentificador(identificador);
		setNombre(nombre);
		

	}

	public TipoDescuentoDTO() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);		
		setNombre(UtilText.getDefaultValue());
		
	}

	public static TipoDescuentoDTO create() {
		return new TipoDescuentoDTO();
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	public final TipoDescuentoDTO setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public final String getNombre() {
		return nombre;
	}

	public final TipoDescuentoDTO setNombre(String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
		return this;
	}


}
