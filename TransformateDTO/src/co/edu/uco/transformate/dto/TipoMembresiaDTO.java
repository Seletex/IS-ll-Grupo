package co.edu.uco.transformate.dto;

import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class TipoMembresiaDTO {

	private UUID identificador;
	private String nombre;

	public TipoMembresiaDTO(UUID identificador, String nombre) {

		setIdentificador(identificador);
		setNombre(nombre);
	}

	public TipoMembresiaDTO() {
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setNombre(UtilText.getDefaultValue());

	}

	public static TipoMembresiaDTO create() {
		return new TipoMembresiaDTO();
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	public final TipoMembresiaDTO setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public final String getNombre() {
		return nombre;
	}

	public final TipoMembresiaDTO setNombre(String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
		return this;
	}
}
