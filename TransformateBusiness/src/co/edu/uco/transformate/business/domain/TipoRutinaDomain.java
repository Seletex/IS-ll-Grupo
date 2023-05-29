package co.edu.uco.transformate.business.domain;


import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class TipoRutinaDomain {
	
	private UUID identificador;
	private String nombre;
	private String descripcion;
	

	private static final TipoRutinaDomain DEFAULT_OBJECT = new TipoRutinaDomain();

	public static TipoRutinaDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static TipoRutinaDomain create(UUID identificadorUuid, String fechaDate, String descripcion
			) {
		return new TipoRutinaDomain(identificadorUuid,fechaDate,descripcion);
	}
	
	

	public TipoRutinaDomain(UUID identificador, String nombre, String descripcion) {
		
		setIdentificador(identificador);
		setNombre(nombre);
		setDescripcion(descripcion);
		

	}

	private TipoRutinaDomain() {
	
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setDescripcion(UtilText.EMPTY);
		setNombre(UtilText.getDefaultValue());
		
	}

	public final String getDescripcion() {
		return descripcion;
	}

	private final void setDescripcion(String descripcion) {
		this.descripcion = UtilText.getUtilText().applyTrim(descripcion);
	
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
