package co.edu.uco.transformate.dto;

import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class TipoEgresoDTO {

	private UUID identificador;
	private String nombre;

	public TipoEgresoDTO(UUID identificador, String nombre) {

		setIdentificador(identificador);
		setNombre(nombre);
	}

	public TipoEgresoDTO() {
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setNombre(UtilText.getDefaultValue());

	}

	public static TipoEgresoDTO create() {
		return new TipoEgresoDTO();
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	public final TipoEgresoDTO setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public final String getNombre() {
		return nombre;
	}

	public final TipoEgresoDTO setNombre(String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
		return this;
	}
}
