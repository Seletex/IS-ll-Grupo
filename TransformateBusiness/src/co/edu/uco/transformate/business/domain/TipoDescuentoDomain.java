package co.edu.uco.transformate.business.domain;

import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class TipoDescuentoDomain {
	
	private UUID identificador;
	private String nombre;
	

	private static final TipoDescuentoDomain DEFAULT_OBJECT = new TipoDescuentoDomain();

	public static TipoDescuentoDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static TipoDescuentoDomain create(UUID identificadorUuid,  String descripcion
			) {
		return new TipoDescuentoDomain(identificadorUuid,descripcion);
	}
	
	public TipoDescuentoDomain(UUID identificador, String nombre) {
	
		setIdentificador(identificador);
		setNombre(nombre);
		

	}

	private TipoDescuentoDomain() {
		
		setIdentificador(UtilUUID.DEFAULT_UUID);		
		setNombre(UtilText.getDefaultValue());
		
	}

	public static TipoDescuentoDomain create() {
		return new TipoDescuentoDomain();
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
