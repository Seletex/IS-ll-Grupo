package co.edu.uco.transformate.business.domain;


import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class ZonaDomain {

	private UUID identificador;
	private String nombre;
	private String descripcion;
	private GimnasioDomain gimnasioDomain;
	

	private static final ZonaDomain DEFAULT_OBJECT = new ZonaDomain();

	public static ZonaDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static ZonaDomain create(UUID identificador, String nombre, String descripcion, GimnasioDomain gimnasioDomain
			) {
		return new ZonaDomain(identificador,nombre,descripcion, gimnasioDomain);
	}

	private ZonaDomain(UUID identificador, String nombre, String descripcion, GimnasioDomain gimnasioDomain) {
		super();
		setIdentificador(identificador);
		setNombre(nombre);
		setDescripcion(descripcion);
		setGimnasioDTO(gimnasioDomain);

	}

	private ZonaDomain() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setGimnasioDTO(GimnasioDomain.getDefaultObject());
		setNombre(UtilText.getDefaultValue());
		setDescripcion(UtilText.EMPTY);
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

	public final String getDescripcion() {
		return descripcion;
	}

	private final void setDescripcion(String descripcion) {
		this.descripcion = UtilText.getUtilText().applyTrim(descripcion);
		
	}

	public final GimnasioDomain getGimnasioDTO() {
		return gimnasioDomain;
	}

	private final void setGimnasioDTO(GimnasioDomain gimnasioDomain) {
		this.gimnasioDomain = UtilObject.getDefault(gimnasioDomain, GimnasioDomain.getDefaultObject());
	
	}

}
