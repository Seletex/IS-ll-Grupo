package co.edu.uco.transformate.business.domain;

import java.time.LocalDate;

import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilDate;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class HistorialProgresoDomain {

	private UUID identificador;
	private LocalDate fecha;
	private String descripcion;

	private String nombreMiembro;
	
	

	public static HistorialProgresoDomain create(UUID identificadorUuid, LocalDate fechaDate, String descripcion,
			String nombreMiembroString) {
		return new HistorialProgresoDomain(identificadorUuid,fechaDate,descripcion,nombreMiembroString);
	}

	public  HistorialProgresoDomain(UUID identificador, LocalDate fecha, String descripcion, String nombreMiembro) {
		
		setFecha(fecha);
		setDescripcion(descripcion);
		setIdentificador(identificador);
		setNombreMiembro(nombreMiembro);

	}




	public UUID getIdentificador() {
		return identificador;
	}

	private void setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
	
	}

	public LocalDate getFecha() {
		return fecha;
	}

	private void setFecha(LocalDate fecha) {
		this.fecha = UtilDate.getDefault(fecha);
	
	}

	public String getNombreMiembro() {
		return nombreMiembro;
	}

	private void setNombreMiembro(String nombreMiembro) {
		this.nombreMiembro = UtilText.getUtilText().applyTrim(nombreMiembro);
	
	}

	public String getDescripcion() {
		return descripcion;
	}

	private void setDescripcion(String descripcion) {
		this.descripcion = UtilText.getUtilText().applyTrim(descripcion);
	
	}
}
