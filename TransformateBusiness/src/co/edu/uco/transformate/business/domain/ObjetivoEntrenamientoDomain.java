package co.edu.uco.transformate.business.domain;


import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class ObjetivoEntrenamientoDomain {

	private UUID identificador;
	private String descripcion;
	

	private static final ObjetivoEntrenamientoDomain DEFAULT_OBJECT = new ObjetivoEntrenamientoDomain();

	public static ObjetivoEntrenamientoDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static ObjetivoEntrenamientoDomain create(UUID identificadorUuid,  String descripcion
			) {
		return new ObjetivoEntrenamientoDomain(identificadorUuid,descripcion);
	}

	public ObjetivoEntrenamientoDomain(UUID identificador, String nombre) {

		setIdentificador(identificador);
		setDescripcion(nombre);
	}

	private ObjetivoEntrenamientoDomain() {
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setDescripcion(UtilText.getDefaultValue());

	}



	public final UUID getIdentificador() {
		return identificador;
	}

	private final void setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		
	}

	public final String getDescripcion() {
		return descripcion;
	}

	private final void setDescripcion(String nombre) {
		this.descripcion = UtilText.getUtilText().applyTrim(nombre);
	
	}
}
