package co.edu.uco.transformate.entities;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilDate;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class HistorialPruebaFisicaEntity {

	private UUID identificador;
	private LocalDate fecha;
	private String descripcion;

	public HistorialPruebaFisicaEntity(UUID identificador, LocalDate fecha, String descripcion) {
		super();
		setFecha(fecha);
		setDescripcion(descripcion);
		setIdentificador(identificador);

	}

	public HistorialPruebaFisicaEntity() {
		super();
		setFecha(UtilDate.DEFAULT_DATE);
		setDescripcion(UtilText.getDefaultValue());
		setIdentificador(UtilUUID.DEFAULT_UUID);

	}

	public static HistorialPruebaFisicaEntity create() {
		return new HistorialPruebaFisicaEntity();
	}

	public UUID getIdentificador() {
		return identificador;
	}

	public HistorialPruebaFisicaEntity setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public HistorialPruebaFisicaEntity setFecha(LocalDate fecha) {
		this.fecha = UtilDate.getDefault(fecha);
		return this;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public HistorialPruebaFisicaEntity setDescripcion(String descripcion) {
		this.descripcion = UtilText.getUtilText().applyTrim(descripcion);
		return this;
	}

}
