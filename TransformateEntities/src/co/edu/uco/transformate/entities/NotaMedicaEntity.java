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

	public static NotaMedicaEntity create(UUID identificador, String descripcion,MiembroEntity miembroEntity
			) {
		return new NotaMedicaEntity(identificador,descripcion,miembroEntity);
	}
	
	public NotaMedicaEntity(UUID identificador, String descripcion,MiembroEntity miembroEntity) {


		setIdentificador(identificador);
		setDescripcion(descripcion);
		setMiembroDTO(miembroEntity);

	}

	private NotaMedicaEntity() {
		
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setMiembroDTO(MiembroEntity.getDefaultObject());
		setDescripcion(UtilText.getDefaultValue());
		
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

	public final NotaMedicaEntity setDescripcion(String descripcion) {
		this.descripcion = UtilText.getUtilText().applyTrim(descripcion);
		return this;
	}

	public MiembroEntity getMiembroDTO() {
		return miembroEntity;
	}

	public NotaMedicaEntity setMiembroDTO(MiembroEntity miembroEntity) {
		this.miembroEntity = UtilObject.getDefault(miembroEntity,MiembroEntity.getDefaultObject());return this;
	}

}
