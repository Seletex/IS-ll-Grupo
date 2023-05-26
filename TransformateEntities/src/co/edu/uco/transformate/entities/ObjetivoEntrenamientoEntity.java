package co.edu.uco.transformate.entities;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class ObjetivoEntrenamientoEntity {

	private UUID identificador;
	private String descripcion;
	

	private static final ObjetivoEntrenamientoEntity DEFAULT_OBJECT = new ObjetivoEntrenamientoEntity();

	public static ObjetivoEntrenamientoEntity getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static ObjetivoEntrenamientoEntity create(UUID identificadorUuid,  String descripcion
			) {
		return new ObjetivoEntrenamientoEntity(identificadorUuid,descripcion);
	}

	private ObjetivoEntrenamientoEntity(UUID identificador, String nombre) {

		setIdentificador(identificador);
		setDescripcion(nombre);
	}

	private ObjetivoEntrenamientoEntity() {
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setDescripcion(UtilText.getDefaultValue());

	}

	public static ObjetivoEntrenamientoEntity create() {
		return new ObjetivoEntrenamientoEntity();
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
