package co.edu.uco.transformate.entities;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilDate;
import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class EventoEntity {

	private UUID identificador;
	private String descripcionString;
	private LocalDate fechaInicioDate;
	private LocalDate fechaFinDate;
	private GimnasioEntity gimnasioEntity;

	private static final EventoEntity DEFAULT_OBJECT = new EventoEntity();

	public static EventoEntity getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static EventoEntity create(GimnasioEntity gimnasioEntity, UUID identificador, String descripcionString,
			LocalDate fechaInicioDate, LocalDate fechaFinDate) {
		return new EventoEntity(gimnasioEntity,identificador,descripcionString,fechaInicioDate,fechaFinDate);
	}

	private EventoEntity(GimnasioEntity gimnasioEntity, UUID identificador, String descripcionString,
			LocalDate fechaInicioDate, LocalDate fechaFinDate) {

		setDescripcionString(descripcionString);
		setFechaFinDate(fechaFinDate);
		setFechaInicioDate(fechaInicioDate);
		setGimnasioDTO(gimnasioEntity);
		setIdentificador(identificador);
	}

	private EventoEntity() {
		super();
		setDescripcionString(UtilText.getDefaultValue());
		setFechaFinDate(UtilDate.DEFAULT_DATE);
		setFechaInicioDate(UtilDate.DEFAULT_DATE);
		setGimnasioDTO(GimnasioEntity.create());
		setIdentificador(UtilUUID.DEFAULT_UUID);
	}

	public static EventoEntity create() {
		return new EventoEntity();
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

	public GimnasioEntity getGimnasioDTO() {
		return gimnasioEntity;
	}

	private void setGimnasioDTO(GimnasioEntity gimnasioEntity) {
		this.gimnasioEntity = UtilObject.getDefault(gimnasioEntity, GimnasioEntity.create());
	
	}

}
