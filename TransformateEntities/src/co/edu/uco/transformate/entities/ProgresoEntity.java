package co.edu.uco.transformate.entities;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilDate;
import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class ProgresoEntity {
	




	private LocalDate fecha;
	private UUID identificador;
	private MiembroEntity miembroEntity;
	private String descripcion;
	
	public ProgresoEntity(UUID identificador, String nombre,MiembroEntity miembroEntity,LocalDate fecha) {
		super();
		setIdentificador(identificador);
		setDescripcion(nombre);
		setMiembroDTO(miembroEntity);
setFecha(fecha);
	}

	public ProgresoEntity() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setMiembroDTO(MiembroEntity.create());
		setDescripcion(UtilText.getDefaultValue());
		setFecha(UtilDate.DEFAULT_DATE);
	}

	public static ProgresoEntity create() {
		return new ProgresoEntity();
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	public final ProgresoEntity setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public final String getDescripcion() {
		return descripcion;
	}

	public final ProgresoEntity setDescripcion(String nombre) {
		this.descripcion = UtilText.getUtilText().applyTrim(nombre);
		return this;
	}

	public MiembroEntity getMiembroDTO() {
		return miembroEntity;
	}

	public ProgresoEntity setMiembroDTO(MiembroEntity miembroEntity) {
		this.miembroEntity = UtilObject.getDefault(miembroEntity,MiembroEntity.create());return this;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = UtilDate.getDefault(fecha);
	}

}
