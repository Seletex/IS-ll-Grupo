package co.edu.uco.transformate.entities;


import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class ZonaEntity {

	private UUID identificador;
	private String nombre;
	private String descripcion;
	private GimnasioEntity gimnasioEntity;
	

	private static final ZonaEntity DEFAULT_OBJECT = new ZonaEntity();

	public static ZonaEntity getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static ZonaEntity create(UUID identificador, String nombre, String descripcion, GimnasioEntity gimnasioEntity
			) {
		return new ZonaEntity(identificador,nombre,descripcion, gimnasioEntity);
	}

	private ZonaEntity(UUID identificador, String nombre, String descripcion, GimnasioEntity gimnasioEntity) {
		super();
		setIdentificador(identificador);
		setNombre(nombre);
		setDescripcion(descripcion);
		setGimnasioDTO(gimnasioEntity);

	}

	private ZonaEntity() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setGimnasioDTO(GimnasioEntity.create());
		setNombre(UtilText.getDefaultValue());
		setDescripcion(UtilText.EMPTY);
	}

	public static ZonaEntity create() {
		return new ZonaEntity();
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

	public final GimnasioEntity getGimnasioDTO() {
		return gimnasioEntity;
	}

	private final void setGimnasioDTO(GimnasioEntity gimnasioEntity) {
		this.gimnasioEntity = UtilObject.getDefault(gimnasioEntity, GimnasioEntity.create());
	
	}

}
