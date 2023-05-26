package co.edu.uco.transformate.entities;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class TipoRutinaEntity {
	
	private UUID identificador;
	private String nombre;
	private String descripcion;
	

	private static final TipoRutinaEntity DEFAULT_OBJECT = new TipoRutinaEntity();

	public static TipoRutinaEntity getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static TipoRutinaEntity create(UUID identificadorUuid, String fechaDate, String descripcion
			) {
		return new TipoRutinaEntity(identificadorUuid,fechaDate,descripcion);
	}
	
	

	private TipoRutinaEntity(UUID identificador, String nombre, String descripcion) {
		super();
		setIdentificador(identificador);
		setNombre(nombre);
		setDescripcion(descripcion);
		

	}

	private TipoRutinaEntity() {
		super();
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

	
	public static TipoRutinaEntity create() {
		return new TipoRutinaEntity();
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
