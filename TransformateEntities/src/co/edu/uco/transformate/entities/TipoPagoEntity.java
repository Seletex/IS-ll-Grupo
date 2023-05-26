package co.edu.uco.transformate.entities;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class TipoPagoEntity {
	
	private UUID identificador;
	private String nombre;
	

	private static final TipoPagoEntity DEFAULT_OBJECT = new TipoPagoEntity();

	public static TipoPagoEntity getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static TipoPagoEntity create(UUID identificadorUuid, String descripcion
			) {
		return new TipoPagoEntity(identificadorUuid,descripcion);
	}
	

	private TipoPagoEntity(UUID identificador, String nombre) {
		
		setIdentificador(identificador);
		setNombre(nombre);
		

	}

	private TipoPagoEntity() {
	
		setIdentificador(UtilUUID.DEFAULT_UUID);
		
		setNombre(UtilText.getDefaultValue());
		
	}

	public static TipoPagoEntity create() {
		return new TipoPagoEntity();
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
