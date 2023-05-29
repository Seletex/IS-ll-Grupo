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
	


	public static HistorialNotaMedicaEntity create(UUID identificadorUuid, LocalDate fechaDate, String descripcion,
			String nombreMiembroString) {
		return new HistorialNotaMedicaEntity(identificadorUuid,fechaDate,descripcion,nombreMiembroString);
	}

	public  HistorialNotaMedicaEntity(UUID identificadorUuid, LocalDate fechaDate, String descripcion,
			String nombreMiembroString) {
	
		setDescripcion(descripcion);
		setFechaDate(fechaDate);
		setIdentificadorUuid(identificadorUuid);
		setNombreMiembroString(nombreMiembroString);

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
