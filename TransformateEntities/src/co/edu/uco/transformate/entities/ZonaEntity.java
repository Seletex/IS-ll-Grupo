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

	public ZonaEntity(UUID identificador, String nombre, String descripcion, GimnasioEntity gimnasioEntity) {
		super();
		setIdentificador(identificador);
		setNombre(nombre);
		setDescripcion(descripcion);
		setGimnasioDTO(gimnasioEntity);

	}

	public ZonaEntity() {
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

	public final ZonaEntity setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public final String getNombre() {
		return nombre;
	}

	public final ZonaEntity setNombre(String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
		return this;
	}

	public final String getDescripcion() {
		return descripcion;
	}

	public final ZonaEntity setDescripcion(String descripcion) {
		this.descripcion = UtilText.getUtilText().applyTrim(descripcion);
		return this;
	}

	public final GimnasioEntity getGimnasioDTO() {
		return gimnasioEntity;
	}

	public final ZonaEntity setGimnasioDTO(GimnasioEntity gimnasioEntity) {
		this.gimnasioEntity = UtilObject.getDefault(gimnasioEntity, GimnasioEntity.create());
		return this;
	}

}
