package co.edu.uco.transformate.entities;

import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class TipoMiembroEntity {
	private UUID identificador;
	private String nombre;
	private TipoDescuentoEntity tipoDescuentoEntity;

	public TipoMiembroEntity(UUID identificador, String nombre) {
		
		setIdentificador(identificador);
		setNombre(nombre);
		setTipoDescuentoDTO(tipoDescuentoEntity);

	}

	public TipoMiembroEntity() {
		
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setTipoDescuentoDTO(TipoDescuentoEntity.create());
		setNombre(UtilText.getDefaultValue());
		
	}

	public final TipoDescuentoEntity getTipoDescuentoDTO() {
		return tipoDescuentoEntity;
	}

	public final TipoMiembroEntity setTipoDescuentoDTO(TipoDescuentoEntity tipoDescuentoEntity) {
		this.tipoDescuentoEntity = UtilObject.getDefault(tipoDescuentoEntity, TipoDescuentoEntity.create());;
		return this;
	}

	public static TipoMiembroEntity create() {
		return new TipoMiembroEntity();
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	public final TipoMiembroEntity setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public final String getNombre() {
		return nombre;
	}

	public final TipoMiembroEntity setNombre(String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
		return this;
	}

}
