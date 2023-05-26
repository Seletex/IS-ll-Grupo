package co.edu.uco.transformate.entities;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class TipoMembresiaEntity {

	private UUID identificador;
	private String nombre;
	

	private static final TipoMembresiaEntity DEFAULT_OBJECT = new TipoMembresiaEntity();

	public static TipoMembresiaEntity getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static TipoMembresiaEntity create(UUID identificadorUuid, String descripcion
			) {
		return new TipoMembresiaEntity(identificadorUuid,descripcion);
	}

	private TipoMembresiaEntity(UUID identificador, String nombre) {

		setIdentificador(identificador);
		setNombre(nombre);
	}

	private TipoMembresiaEntity() {
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setNombre(UtilText.getDefaultValue());

	}

	public static TipoMembresiaEntity create() {
		return new TipoMembresiaEntity();
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
