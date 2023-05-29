package co.edu.uco.transformate.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilDate;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class HistorialClaseEntity {
	private UUID identificador;
	private LocalDate fecha;
	private LocalDateTime horaInicio;
	private LocalDateTime horaFin;
	private String nombreEntrenador;

	

	public static HistorialClaseEntity create(UUID identificador, LocalDate fecha, LocalDateTime horaInicio,
			LocalDateTime horaFin, String nombreEntrenador) {
		return new HistorialClaseEntity(identificador,fecha,horaInicio,horaFin,nombreEntrenador);
	}

	public   HistorialClaseEntity(UUID identificador, LocalDate fecha, LocalDateTime horaInicio, LocalDateTime horaFin,
			String nombreEntrenador) {
		
		setFecha(fecha);
		setHoraFin(horaFin);
		setHoraInicio(horaInicio);
		setIdentificador(identificador);
		setNombreEntrenador(nombreEntrenador);

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

	public LocalDateTime getHoraInicio() {
		return horaInicio;
	}

	private void setHoraInicio(LocalDateTime horaInicio) {
		this.horaInicio = UtilDate.getDefaultTime(horaInicio);
	
	}

	public LocalDateTime getHoraFin() {
		return horaFin;
	}

	private void setHoraFin(LocalDateTime horaFin) {
		this.horaFin = UtilDate.getDefaultTime(horaFin);
	
	}

	public String getNombreEntrenador() {
		return nombreEntrenador;
	}

	private void setNombreEntrenador(String nombreEntrenador) {
		this.nombreEntrenador = UtilText.getUtilText().applyTrim(nombreEntrenador);
		
	}

}
