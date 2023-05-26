package co.edu.uco.transformate.entities;

import java.time.LocalDate;

import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilDate;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class HistorialProgresoEntity {

	private UUID identificador;
	private LocalDate fecha;
	private String descripcion;

	private String nombreMiembro;
	
	private static final HistorialProgresoEntity DEFAULT_OBJECT = new HistorialProgresoEntity();

	public static HistorialProgresoEntity getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static HistorialProgresoEntity create(UUID identificadorUuid, LocalDate fechaDate, String descripcion,
			String nombreMiembroString) {
		return new HistorialProgresoEntity(identificadorUuid,fechaDate,descripcion,nombreMiembroString);
	}

	private HistorialProgresoEntity(UUID identificador, LocalDate fecha, String descripcion, String nombreMiembro) {
		super();
		setFecha(fecha);
		setDescripcion(descripcion);
		setIdentificador(identificador);
		setNombreMiembro(nombreMiembro);

	}

	private HistorialProgresoEntity() {
		super();
		setFecha(UtilDate.DEFAULT_DATE);
		setDescripcion(UtilText.EMPTY);
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setNombreMiembro(UtilText.getDefaultValue());
	}

	public static HistorialProgresoEntity create() {
		return new HistorialProgresoEntity();
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
