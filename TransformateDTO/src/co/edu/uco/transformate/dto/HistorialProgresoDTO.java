package co.edu.uco.transformate.dto;

import java.time.LocalDate;

import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilDate;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class HistorialProgresoDTO {

	private UUID identificador;
	private LocalDate fecha;
	private String descripcion;

	private String nombreMiembro;

	public HistorialProgresoDTO(UUID identificador, LocalDate fecha, String descripcion, String nombreMiembro) {
		super();
		setFecha(fecha);
		setDescripcion(descripcion);
		setIdentificador(identificador);
		setNombreMiembro(nombreMiembro);

	}

	public HistorialProgresoDTO() {
		super();
		setFecha(UtilDate.DEFAULT_DATE);
		setDescripcion(UtilText.EMPTY);
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setNombreMiembro(UtilText.getDefaultValue());
	}

	public static HistorialProgresoDTO create() {
		return new HistorialProgresoDTO();
	}

	public UUID getIdentificador() {
		return identificador;
	}

	public HistorialProgresoDTO setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public HistorialProgresoDTO setFecha(LocalDate fecha) {
		this.fecha = UtilDate.getDefault(fecha);
		return this;
	}

	public String getNombreMiembro() {
		return nombreMiembro;
	}

	public HistorialProgresoDTO setNombreMiembro(String nombreMiembro) {
		this.nombreMiembro = UtilText.getUtilText().applyTrim(nombreMiembro);
		return this;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public HistorialProgresoDTO setDescripcion(String descripcion) {
		this.descripcion = UtilText.getUtilText().applyTrim(descripcion);
		return this;
	}
}
