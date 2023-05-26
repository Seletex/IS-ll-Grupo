package co.edu.uco.transformate.entities;


import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class NotaMedicaEntity {
	
	private UUID identificador;
	private MiembroEntity miembroEntity;
	private String descripcion;
	

	private static final NotaMedicaEntity DEFAULT_OBJECT = new NotaMedicaEntity();

	public static NotaMedicaEntity getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static NotaMedicaEntity create(UUID identificador, String nombre,MiembroEntity miembroEntity
			) {
		return new NotaMedicaEntity(identificador,nombre,miembroEntity);
	}
	
	public NotaMedicaEntity(UUID identificador, String nombre,MiembroEntity miembroEntity) {
		super();
		setIdentificador(identificador);
		setDescripcion(nombre);
		setMiembroDTO(miembroEntity);

	}

	public NotaMedicaEntity() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setMiembroDTO(MiembroEntity.create());
		setDescripcion(UtilText.getDefaultValue());
		
	}

	public static NotaMedicaEntity create() {
		return new NotaMedicaEntity();
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	public final NotaMedicaEntity setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public final String getDescripcion() {
		return descripcion;
	}

	public final NotaMedicaEntity setDescripcion(String nombre) {
		this.descripcion = UtilText.getUtilText().applyTrim(nombre);
		return this;
	}

	public MiembroEntity getMiembroDTO() {
		return miembroEntity;
	}

	public NotaMedicaEntity setMiembroDTO(MiembroEntity miembroEntity) {
		this.miembroEntity = UtilObject.getDefault(miembroEntity,MiembroEntity.create());return this;
	}

}
