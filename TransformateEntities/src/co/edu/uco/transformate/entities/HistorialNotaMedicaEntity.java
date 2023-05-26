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
	
	private static final HistorialNotaMedicaEntity DEFAULT_OBJECT = new HistorialNotaMedicaEntity();

	public static HistorialNotaMedicaEntity getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static HistorialNotaMedicaEntity create(UUID identificadorUuid, LocalDate fechaDate, String descripcion,
			String nombreMiembroString) {
		return new HistorialNotaMedicaEntity(identificadorUuid,fechaDate,descripcion,nombreMiembroString);
	}

	private HistorialNotaMedicaEntity(UUID identificadorUuid, LocalDate fechaDate, String descripcion,
			String nombreMiembroString) {
		super();
		setDescripcion(descripcion);
		setFechaDate(fechaDate);
		setIdentificadorUuid(identificadorUuid);
		setNombreMiembroString(nombreMiembroString);

	}

	private HistorialNotaMedicaEntity() {
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

	private void  setIdentificadorUuid(UUID identificadorUuid) {
		this.identificadorUuid = UtilUUID.getDefault(identificadorUuid);

	}

	public LocalDate getFechaDate() {
		return fechaDate;
	}

	private void  setFechaDate(LocalDate fecha) {
		this.fechaDate = UtilDate.getDefault(fecha);

	}

	public String getDescripcion() {
		return descripcion;
	}

	private void  setDescripcion(String descripcion) {
		this.descripcion = UtilText.getUtilText().applyTrim(descripcion);

	}

	public String getNombreMiembroString() {
		return nombreMiembroString;
	}

	private void  setNombreMiembroString(String nombreMiembroString) {
		this.nombreMiembroString = UtilText.getUtilText().applyTrim(nombreMiembroString);
		
	}

}
