package co.edu.uco.transformate.entities;

import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class TipoPagoEntity {
	
	private UUID identificador;
	private String nombre;
	

	public TipoPagoEntity(UUID identificador, String nombre) {
		super();
		setIdentificador(identificador);
		setNombre(nombre);
		

	}

	public TipoPagoEntity() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		
		setNombre(UtilText.getDefaultValue());
		
	}

	public static TipoPagoEntity create() {
		return new TipoPagoEntity();
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	public final TipoPagoEntity setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public final String getNombre() {
		return nombre;
	}

	public final TipoPagoEntity setNombre(String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
		return this;
	}

	

	

}
