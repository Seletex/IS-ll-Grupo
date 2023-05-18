package co.edu.uco.transformate.dto;

import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;



public class TipoDocumentoDTO {

	private UUID identificador;
	private String nombre;

	public TipoDocumentoDTO(UUID identificador, String nombre) {

		setIdentificador(identificador);
		setNombre(nombre);
	}

	public TipoDocumentoDTO() {
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setNombre(UtilText.getDefaultValue());

	}

	public static TipoDocumentoDTO create() {
		return new TipoDocumentoDTO();
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	public final TipoDocumentoDTO setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public final String getNombre() {
		return nombre;
	}

	public final TipoDocumentoDTO setNombre(String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
		return this;
	}

}
