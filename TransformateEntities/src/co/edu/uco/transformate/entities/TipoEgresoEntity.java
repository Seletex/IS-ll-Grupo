package co.edu.uco.transformate.entities;


import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class TipoEgresoEntity {

	private UUID identificador;
	private String nombre;
	

	private static final TipoEgresoEntity DEFAULT_OBJECT = new TipoEgresoEntity();

	public static TipoEgresoEntity getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static TipoEgresoEntity create(UUID identificadorUuid, String descripcion
			) {
		return new TipoEgresoEntity(identificadorUuid,descripcion);
	}

	public TipoEgresoEntity(UUID identificador, String nombre) {

		setIdentificador(identificador);
		setNombre(nombre);
	}
	private TipoEgresoEntity() {
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setNombre(UtilText.getDefaultValue());

	}

	

	public final UUID getIdentificador() {
		return identificador;
	}

	private final void setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
	
	}

	public final String getNombre() {
		return nombre;
	}

	private final void setNombre(String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
	
	}
}
