package co.edu.uco.transformate.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilDate;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class HistorialClaseDTO {
	private UUID identificador;
	private LocalDate fecha;
	private LocalDateTime horaInicio;
	private LocalDateTime horaFin;
	private String nombreEntrenador;
	
	public HistorialClaseDTO(UUID identificador, LocalDate fecha, LocalDateTime horaInicio, LocalDateTime horaFin,
			String nombreEntrenador) {
		super();
		setFecha(fecha);
		setHoraFin(horaFin);
		setHoraInicio(horaInicio);
		setIdentificador(identificador);
		setNombreEntrenador(nombreEntrenador);
		
	}
	
	public HistorialClaseDTO() {
		super();
		setFecha(UtilDate.DEFAULT_DATE);
		setHoraFin(UtilDate.DEFAULT_DATE_TIME);
		setHoraInicio(UtilDate.DEFAULT_DATE_TIME);
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setNombreEntrenador(UtilText.getDefaultValue());
	}
	
	public static HistorialClaseDTO create() {
		return new HistorialClaseDTO();
	}

	public UUID getIdentificador() {
		return identificador;
	}
	public HistorialClaseDTO setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);return this;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public HistorialClaseDTO setFecha(LocalDate fecha) {
		this.fecha = UtilDate.getDefault(fecha);return this;
	}
	public LocalDateTime getHoraInicio() {
		return horaInicio;
	}
	public HistorialClaseDTO setHoraInicio(LocalDateTime horaInicio) {
		this.horaInicio = UtilDate.getDefaultTime(horaInicio);return this;
	}
	public LocalDateTime getHoraFin() {
		return horaFin;
	}
	public HistorialClaseDTO setHoraFin(LocalDateTime horaFin) {
		this.horaFin = UtilDate.getDefaultTime(horaFin);return this;
	}
	public String getNombreEntrenador() {
		return nombreEntrenador;
	}
	public HistorialClaseDTO setNombreEntrenador(String nombreEntrenador) {
		this.nombreEntrenador = UtilText.getUtilText().applyTrim(nombreEntrenador);return this;
	}
	
	
}
