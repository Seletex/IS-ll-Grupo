package co.edu.uco.transformate.entities;

import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class TipoDescuentoEntity {
	
	private UUID identificador;
	private String nombre;
	

	private static final TipoDescuentoEntity DEFAULT_OBJECT = new TipoDescuentoEntity();

	public static TipoDescuentoEntity getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static TipoDescuentoEntity create(UUID identificadorUuid,  String descripcion
			) {
		return new TipoDescuentoEntity(identificadorUuid,descripcion);
	}
	
	public TipoDescuentoEntity(UUID identificador, String nombre) {
	
		setIdentificador(identificador);
		setNombre(nombre);
		

	}

	private TipoDescuentoEntity() {
		
		setIdentificador(UtilUUID.DEFAULT_UUID);		
		setNombre(UtilText.getDefaultValue());
		
	}

	public static TipoDescuentoEntity create() {
		return new TipoDescuentoEntity();
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
