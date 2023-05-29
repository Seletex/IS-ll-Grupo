package co.edu.uco.transformate.business.domain;


import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class TipoMembresiaDomain {

	private UUID identificador;
	private String nombre;
	

	private static final TipoMembresiaDomain DEFAULT_OBJECT = new TipoMembresiaDomain();

	public static TipoMembresiaDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static TipoMembresiaDomain create(UUID identificadorUuid, String descripcion
			) {
		return new TipoMembresiaDomain(identificadorUuid,descripcion);
	}

	public TipoMembresiaDomain(UUID identificador, String nombre) {

		setIdentificador(identificador);
		setNombre(nombre);
	}

	private TipoMembresiaDomain() {
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
