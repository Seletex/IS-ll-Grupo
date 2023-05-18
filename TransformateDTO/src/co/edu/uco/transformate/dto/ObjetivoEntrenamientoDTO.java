package co.edu.uco.transformate.dto;

import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class ObjetivoEntrenamientoDTO {

	private UUID identificador;
	private String descripcion;

	public ObjetivoEntrenamientoDTO(UUID identificador, String nombre) {

		setIdentificador(identificador);
		setDescripcion(nombre);
	}

	public ObjetivoEntrenamientoDTO() {
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setDescripcion(UtilText.getDefaultValue());

	}

	public static ObjetivoEntrenamientoDTO create() {
		return new ObjetivoEntrenamientoDTO();
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	public final ObjetivoEntrenamientoDTO setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public final String getDescripcion() {
		return descripcion;
	}

	public final ObjetivoEntrenamientoDTO setDescripcion(String nombre) {
		this.descripcion = UtilText.getUtilText().applyTrim(nombre);
		return this;
	}
}
