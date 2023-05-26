package co.edu.uco.transformate.entities;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class TipoMiembroEntity {
	private UUID identificador;
	private String nombre;
	private TipoDescuentoEntity tipoDescuentoEntity;
	

	private static final TipoMiembroEntity DEFAULT_OBJECT = new TipoMiembroEntity();

	public static TipoMiembroEntity getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static TipoMiembroEntity create(UUID identificadorUuid, String descripcion,TipoDescuentoEntity tipoDescuentoEntity
			) {
		return new TipoMiembroEntity(identificadorUuid,descripcion,tipoDescuentoEntity);
	}

	private TipoMiembroEntity(UUID identificador, String nombre, TipoDescuentoEntity tipoDescuentoEntity) {
		
		setIdentificador(identificador);
		setNombre(nombre);
		setTipoDescuentoDTO(tipoDescuentoEntity);

	}

	private TipoMiembroEntity() {
		
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setTipoDescuentoDTO(TipoDescuentoEntity.create());
		setNombre(UtilText.getDefaultValue());
		
	}

	public final TipoDescuentoEntity getTipoDescuentoDTO() {
		return tipoDescuentoEntity;
	}

	private final void setTipoDescuentoDTO(TipoDescuentoEntity tipoDescuentoEntity) {
		this.tipoDescuentoEntity = UtilObject.getDefault(tipoDescuentoEntity, TipoDescuentoEntity.create());;
	
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
