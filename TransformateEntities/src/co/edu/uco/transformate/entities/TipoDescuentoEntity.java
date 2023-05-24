package co.edu.uco.transformate.entities;

import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class TipoDescuentoEntity {
	
	private UUID identificador;
	private String nombre;
	

	public TipoDescuentoEntity(UUID identificador, String nombre) {
		super();
		setIdentificador(identificador);
		setNombre(nombre);
		

	}

	public TipoDescuentoEntity() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);		
		setNombre(UtilText.getDefaultValue());
		
	}

	public static TipoDescuentoEntity create() {
		return new TipoDescuentoEntity();
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	public final TipoDescuentoEntity setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public final String getNombre() {
		return nombre;
	}

	public final TipoDescuentoEntity setNombre(String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
		return this;
	}


}
