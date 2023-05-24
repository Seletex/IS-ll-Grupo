package co.edu.uco.transformate.entities;

import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class TipoMembresiaEntity {

	private UUID identificador;
	private String nombre;

	public TipoMembresiaEntity(UUID identificador, String nombre) {

		setIdentificador(identificador);
		setNombre(nombre);
	}

	public TipoMembresiaEntity() {
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setNombre(UtilText.getDefaultValue());

	}

	public static TipoMembresiaEntity create() {
		return new TipoMembresiaEntity();
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	public final TipoMembresiaEntity setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public final String getNombre() {
		return nombre;
	}

	public final TipoMembresiaEntity setNombre(String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
		return this;
	}
}
