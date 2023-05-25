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
	
	private static final GimnasioEntity DEFAULT_OBJECT = new GimnasioEntity();

	public static GimnasioEntity getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static GimnasioEntity create(UUID identificador, String nombre, String descripcionString, String telefonoString,
			String correoString, LocalDateTime horaAperturaDate, LocalDateTime horaCierreDate) {
		return new GimnasioEntity(identificador,nombre,descripcionString,telefonoString,correoString,horaAperturaDate,horaCierreDate);
	}
	
	public HistorialClaseEntity(UUID identificador, LocalDate fecha, LocalDateTime horaInicio, LocalDateTime horaFin,
			String nombreEntrenador) {
		super();
		setFecha(fecha);
		setHoraFin(horaFin);
		setHoraInicio(horaInicio);
		setIdentificador(identificador);
		setNombreEntrenador(nombreEntrenador);
		
	}
	
	public HistorialClaseEntity() {
		super();
		setFecha(UtilDate.DEFAULT_DATE);
		setHoraFin(UtilDate.DEFAULT_DATE_TIME);
		setHoraInicio(UtilDate.DEFAULT_DATE_TIME);
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setNombreEntrenador(UtilText.getDefaultValue());
	}
	
	public static HistorialClaseEntity create() {
		return new HistorialClaseEntity();
	}

	public UUID getIdentificador() {
		return identificador;
	}
	public HistorialClaseEntity setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);return this;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public HistorialClaseEntity setFecha(LocalDate fecha) {
		this.fecha = UtilDate.getDefault(fecha);return this;
	}
	public LocalDateTime getHoraInicio() {
		return horaInicio;
	}
	public HistorialClaseEntity setHoraInicio(LocalDateTime horaInicio) {
		this.horaInicio = UtilDate.getDefaultTime(horaInicio);return this;
	}
	public LocalDateTime getHoraFin() {
		return horaFin;
	}
	public HistorialClaseEntity setHoraFin(LocalDateTime horaFin) {
		this.horaFin = UtilDate.getDefaultTime(horaFin);return this;
	}
	public String getNombreEntrenador() {
		return nombreEntrenador;
	}
	public HistorialClaseEntity setNombreEntrenador(String nombreEntrenador) {
		this.nombreEntrenador = UtilText.getUtilText().applyTrim(nombreEntrenador);return this;
	}
	
	
}
