package co.edu.uco.transformate.entities;

import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class TipoEgresoEntity {

	private UUID identificador;
	private String nombre;

	public TipoEgresoEntity(UUID identificador, String nombre) {

		setIdentificador(identificador);
		setNombre(nombre);
	}

	public TipoEgresoEntity() {
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setNombre(UtilText.getDefaultValue());

	}

	public static TipoEgresoEntity create() {
		return new TipoEgresoEntity();
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	public final TipoEgresoEntity setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public final String getNombre() {
		return nombre;
	}

	public final TipoEgresoEntity setNombre(String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
		return this;
	}
}
