package co.edu.uco.transformate.entities;

import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class EquipoEntity {

	private UUID identificador;
	private String nombre;
	private String descripcion;
	private ZonaEntity zonaEntity;

	private static final EquipoEntity DEFAULT_OBJECT = new EquipoEntity();

	public static EquipoEntity getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static EquipoEntity create(UUID identificador, String nombre, String descripcion, ZonaEntity zonaEntity) {
		return new EquipoEntity(identificador,nombre,descripcion,zonaEntity);
	}
	
	public  EquipoEntity(UUID identificador, String nombre, String descripcion, ZonaEntity zonaEntity) {
	
		setIdentificador(identificador);
		setNombre(nombre);
		setDescripcion(descripcion);
		setZonaDTO(zonaEntity);

	}



	private EquipoEntity() {
	
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setZonaDTO(ZonaEntity.getDefaultObject());
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

	public final ZonaEntity getZonaDTO() {
		return zonaEntity;
	}

	private final void setZonaDTO(ZonaEntity zonaEntity) {
		this.zonaEntity =  UtilObject.getDefault(zonaEntity, ZonaEntity.getDefaultObject());
		
	}

}
