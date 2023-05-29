package co.edu.uco.transformate.business.domain;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilDate;
import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class EventoDomain {

	private UUID identificador;
	private String descripcionString;
	private LocalDate fechaInicioDate;
	private LocalDate fechaFinDate;
	private GimnasioDomain gimnasioDomain;

	

	

	public static EventoDomain create(GimnasioDomain gimnasioDomain, UUID identificador, String descripcionString,
			LocalDate fechaInicioDate, LocalDate fechaFinDate) {
		return new EventoDomain(gimnasioDomain,identificador,descripcionString,fechaInicioDate,fechaFinDate);
	}

	public  EventoDomain(GimnasioDomain gimnasioDomain, UUID identificador, String descripcionString,
			LocalDate fechaInicioDate, LocalDate fechaFinDate) {

		setDescripcionString(descripcionString);
		setFechaFinDate(fechaFinDate);
		setFechaInicioDate(fechaInicioDate);
		setGimnasioDTO(gimnasioDomain);
		setIdentificador(identificador);
	}

	


	public UUID getIdentificador() {
		return identificador;
	}

	private void setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
	
	}

	public String getDescripcionString() {
		return descripcionString;
	}

	private void setDescripcionString(String descripcionString) {
		this.descripcionString = UtilText.getUtilText().applyTrim(descripcionString);
	
	}

	public LocalDate getFechaInicioDate() {
		return fechaInicioDate;
	}

	private void setFechaInicioDate(LocalDate fechaInicioDate) {
		this.fechaInicioDate = UtilDate.getDefault(fechaInicioDate);
	
	}

	public LocalDate getFechaFinDate() {
		return fechaFinDate;
	}

	private void setFechaFinDate(LocalDate fechaFinDate) {
		this.fechaFinDate = UtilDate.getDefault(fechaFinDate);

	}

	public GimnasioDomain getGimnasioDTO() {
		return gimnasioDomain;
	}

	private void setGimnasioDTO(GimnasioDomain gimnasioDomain) {
		this.gimnasioDomain = UtilObject.getDefault(gimnasioDomain, GimnasioDomain.getDefaultObject());
	
	}

}
