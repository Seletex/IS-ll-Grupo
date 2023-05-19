package co.edu.uco.transformate.dto;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilDate;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class HistorialNotaMedicaDTO {
	
	private UUID identificadorUuid;
	private LocalDate fechaDate;
	private String descripcion;
	private String nombreMiembroString;
	public HistorialNotaMedicaDTO(UUID identificadorUuid, LocalDate fechaDate, String descripcion,
			String nombreMiembroString) {
		super();
		setDescripcion(descripcion);
		setFechaDate(fechaDate);
		setIdentificadorUuid(identificadorUuid);
		setNombreMiembroString(nombreMiembroString);
	
	}
	public HistorialNotaMedicaDTO() {
		super();
		setDescripcion(UtilText.getDefaultValue());
		setFechaDate(UtilDate.DEFAULT_DATE);
		setIdentificadorUuid(UtilUUID.DEFAULT_UUID);
		setNombreMiembroString(UtilText.EMPTY);
	}
	
	public static HistorialNotaMedicaDTO create() {
		return new HistorialNotaMedicaDTO();
	}
	public UUID getIdentificadorUuid() {
		return identificadorUuid;
	}
	public HistorialNotaMedicaDTO setIdentificadorUuid(UUID identificadorUuid) {
		this.identificadorUuid = UtilUUID.getDefault(identificadorUuid);return this;
	}
	public LocalDate getFechaDate() {
		return fechaDate;
	}
	public HistorialNotaMedicaDTO setFechaDate(LocalDate fecha) {
		this.fechaDate = UtilDate.getDefault(fecha);return this;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public HistorialNotaMedicaDTO setDescripcion(String descripcion) {
		this.descripcion = UtilText.getUtilText().applyTrim(descripcion);return this;
	}
	public String getNombreMiembroString() {
		return nombreMiembroString;
	}
	public HistorialNotaMedicaDTO setNombreMiembroString(String nombreMiembroString) {
		this.nombreMiembroString = UtilText.getUtilText().applyTrim(nombreMiembroString);return this;
	}

}
