package co.edu.uco.transformate.entities;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;



public class TipoDocumentoEntity {

	private UUID identificador;
	private String nombre;
	

	private static final TipoDocumentoEntity DEFAULT_OBJECT = new TipoDocumentoEntity();

	public static TipoDocumentoEntity getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static TipoDocumentoEntity create(UUID identificadorUuid,  String descripcion
			) {
		return new TipoDocumentoEntity(identificadorUuid,descripcion);
	}

	private TipoDocumentoEntity(UUID identificador, String nombre) {

		setIdentificador(identificador);
		setNombre(nombre);
	}

	private TipoDocumentoEntity() {
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setNombre(UtilText.getDefaultValue());

	}

	public static TipoDocumentoEntity create() {
		return new TipoDocumentoEntity();
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
