package co.edu.uco.transformate.entities;

import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class ObjetivoEntrenamientoEntity {

	private UUID identificador;
	private String descripcion;

	public ObjetivoEntrenamientoEntity(UUID identificador, String nombre) {

		setIdentificador(identificador);
		setDescripcion(nombre);
	}

	public ObjetivoEntrenamientoEntity() {
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setDescripcion(UtilText.getDefaultValue());

	}

	public static ObjetivoEntrenamientoEntity create() {
		return new ObjetivoEntrenamientoEntity();
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	public final ObjetivoEntrenamientoEntity setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public final String getDescripcion() {
		return descripcion;
	}

	public final ObjetivoEntrenamientoEntity setDescripcion(String nombre) {
		this.descripcion = UtilText.getUtilText().applyTrim(nombre);
		return this;
	}
}
