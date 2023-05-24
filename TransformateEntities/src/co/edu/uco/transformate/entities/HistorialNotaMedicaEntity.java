package co.edu.uco.transformate.entities;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilDate;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class HistorialNotaMedicaEntity {
	
	private UUID identificadorUuid;
	private LocalDate fechaDate;
	private String descripcion;
	private String nombreMiembroString;
	public HistorialNotaMedicaEntity(UUID identificadorUuid, LocalDate fechaDate, String descripcion,
			String nombreMiembroString) {
		super();
		setDescripcion(descripcion);
		setFechaDate(fechaDate);
		setIdentificadorUuid(identificadorUuid);
		setNombreMiembroString(nombreMiembroString);
	
	}
	public HistorialNotaMedicaEntity() {
		super();
		setDescripcion(UtilText.getDefaultValue());
		setFechaDate(UtilDate.DEFAULT_DATE);
		setIdentificadorUuid(UtilUUID.DEFAULT_UUID);
		setNombreMiembroString(UtilText.EMPTY);
	}
	
	public static HistorialNotaMedicaEntity create() {
		return new HistorialNotaMedicaEntity();
	}
	public UUID getIdentificadorUuid() {
		return identificadorUuid;
	}
	public HistorialNotaMedicaEntity setIdentificadorUuid(UUID identificadorUuid) {
		this.identificadorUuid = UtilUUID.getDefault(identificadorUuid);return this;
	}
	public LocalDate getFechaDate() {
		return fechaDate;
	}
	public HistorialNotaMedicaEntity setFechaDate(LocalDate fecha) {
		this.fechaDate = UtilDate.getDefault(fecha);return this;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public HistorialNotaMedicaEntity setDescripcion(String descripcion) {
		this.descripcion = UtilText.getUtilText().applyTrim(descripcion);return this;
	}
	public String getNombreMiembroString() {
		return nombreMiembroString;
	}
	public HistorialNotaMedicaEntity setNombreMiembroString(String nombreMiembroString) {
		this.nombreMiembroString = UtilText.getUtilText().applyTrim(nombreMiembroString);return this;
	}

}
