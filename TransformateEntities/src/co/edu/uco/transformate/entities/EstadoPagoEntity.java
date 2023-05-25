package co.edu.uco.transformate.entities;

import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public final class EstadoPagoEntity {
	
	private UUID identificador;
	private String nombre;
	
	private static final EstadoPagoEntity DEFAULT_OBJECT = new EstadoPagoEntity();

	public static EstadoPagoEntity getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static EstadoPagoEntity create(UUID identificador, String nombre) {
		return new EstadoPagoEntity(identificador,nombre);
	}

	private EstadoPagoEntity(UUID identificador, String nombre) {
		
		setIdentificador(identificador);
		setNombre(nombre);
		

	}

	private EstadoPagoEntity() {
	
		setIdentificador(UtilUUID.DEFAULT_UUID);
		
		setNombre(UtilText.getDefaultValue());
		
	}

	public static EstadoPagoEntity create() {
		return new EstadoPagoEntity();
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
