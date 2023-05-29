package co.edu.uco.transformate.business.domain;


import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;



public class TipoDocumentoDomain {

	private UUID identificador;
	private String nombre;
	

	private static final TipoDocumentoDomain DEFAULT_OBJECT = new TipoDocumentoDomain();

	public static TipoDocumentoDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static TipoDocumentoDomain create(UUID identificadorUuid,  String descripcion
			) {
		return new TipoDocumentoDomain(identificadorUuid,descripcion);
	}

	public TipoDocumentoDomain(UUID identificador, String nombre) {

		setIdentificador(identificador);
		setNombre(nombre);
	}

	private TipoDocumentoDomain() {
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
