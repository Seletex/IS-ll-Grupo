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
	

	public static HistorialPruebaFisicaEntity create(UUID identificadorUuid, LocalDate fechaDate, String descripcion
			) {
		return new HistorialPruebaFisicaEntity(identificadorUuid,fechaDate,descripcion);
	}

	public  HistorialPruebaFisicaEntity(UUID identificador, LocalDate fecha, String descripcion) {
		
		setFecha(fecha);
		setDescripcion(descripcion);
		setIdentificador(identificador);

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
