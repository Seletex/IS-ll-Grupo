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

	public HistorialProgresoEntity(UUID identificador, LocalDate fecha, String descripcion, String nombreMiembro) {
		super();
		setFecha(fecha);
		setDescripcion(descripcion);
		setIdentificador(identificador);
		setNombreMiembro(nombreMiembro);

	}

	public HistorialProgresoEntity() {
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

	public HistorialProgresoEntity setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public HistorialProgresoEntity setFecha(LocalDate fecha) {
		this.fecha = UtilDate.getDefault(fecha);
		return this;
	}

	public String getNombreMiembro() {
		return nombreMiembro;
	}

	public HistorialProgresoEntity setNombreMiembro(String nombreMiembro) {
		this.nombreMiembro = UtilText.getUtilText().applyTrim(nombreMiembro);
		return this;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public HistorialProgresoEntity setDescripcion(String descripcion) {
		this.descripcion = UtilText.getUtilText().applyTrim(descripcion);
		return this;
	}
}
