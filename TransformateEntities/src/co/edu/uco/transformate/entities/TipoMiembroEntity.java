package co.edu.uco.transformate.entities;


import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class TipoMiembroEntity {
	private UUID identificador;
	private String nombre;
	private DescuentoEntity descuentoEntity;
	

	private static final TipoMiembroEntity DEFAULT_OBJECT = new TipoMiembroEntity();

	public static TipoMiembroEntity getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static TipoMiembroEntity create(UUID identificadorUuid, String descripcion,DescuentoEntity tipoDescuentoEntity
			) {
		return new TipoMiembroEntity(identificadorUuid,descripcion,tipoDescuentoEntity);
	}

	public TipoMiembroEntity(UUID identificador, String nombre, DescuentoEntity tipoDescuentoEntity) {
		
		setIdentificador(identificador);
		setNombre(nombre);
		setDescuentoDTO(tipoDescuentoEntity);

	}

	private TipoMiembroEntity() {
		
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setDescuentoDTO(DescuentoEntity.getDefaultObject());
		setNombre(UtilText.getDefaultValue());
		
	}

	public final DescuentoEntity getDescuentoDTO() {
		return descuentoEntity;
	}

	private final void setDescuentoDTO(DescuentoEntity tipoDescuentoEntity) {
		this.descuentoEntity = UtilObject.getDefault(tipoDescuentoEntity, DescuentoEntity.getDefaultObject());
	
	}

	public static TipoMiembroEntity create() {
		return new TipoMiembroEntity();
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
