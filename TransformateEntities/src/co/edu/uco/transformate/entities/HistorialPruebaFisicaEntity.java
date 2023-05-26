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
	
	private static final HistorialPruebaFisicaEntity DEFAULT_OBJECT = new HistorialPruebaFisicaEntity();

	public static HistorialPruebaFisicaEntity getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static HistorialPruebaFisicaEntity create(UUID identificadorUuid, LocalDate fechaDate, String descripcion
			) {
		return new HistorialPruebaFisicaEntity(identificadorUuid,fechaDate,descripcion);
	}

	private HistorialPruebaFisicaEntity(UUID identificador, LocalDate fecha, String descripcion) {
		super();
		setFecha(fecha);
		setDescripcion(descripcion);
		setIdentificador(identificador);

	}

	private HistorialPruebaFisicaEntity() {
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

	private void setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
	
	}

	public LocalDate getFecha() {
		return fecha;
	}

	private void setFecha(LocalDate fecha) {
		this.fecha = UtilDate.getDefault(fecha);
		
	}

	public String getDescripcion() {
		return descripcion;
	}

	private void setDescripcion(String descripcion) {
		this.descripcion = UtilText.getUtilText().applyTrim(descripcion);


	}

}
