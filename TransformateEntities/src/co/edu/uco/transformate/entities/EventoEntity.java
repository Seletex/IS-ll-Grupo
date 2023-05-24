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

	public EventoEntity(GimnasioEntity gimnasioEntity, UUID identificador, String descripcionString, LocalDate fechaInicioDate,
			LocalDate fechaFinDate) {
		super();
		setDescripcionString(descripcionString);
		setFechaFinDate(fechaFinDate);
		setFechaInicioDate(fechaInicioDate);
		setGimnasioDTO(gimnasioEntity);
		setIdentificador(identificador);
	}

	public EventoEntity() {
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

	public EventoEntity setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);return this;
	}

	public String getDescripcionString() {
		return descripcionString;
	}

	public EventoEntity setDescripcionString(String descripcionString) {
		this.descripcionString = UtilText.getUtilText().applyTrim(descripcionString);return this;
	}

	public LocalDate getFechaInicioDate() {
		return fechaInicioDate;
	}

	public EventoEntity setFechaInicioDate(LocalDate fechaInicioDate) {
		this.fechaInicioDate = UtilDate.getDefault(fechaInicioDate);return this;
	}

	public LocalDate getFechaFinDate() {
		return fechaFinDate;
	}

	public EventoEntity setFechaFinDate(LocalDate fechaFinDate) {
		this.fechaFinDate = UtilDate.getDefault(fechaFinDate);return this;
	}

	public GimnasioEntity getGimnasioDTO() {
		return gimnasioEntity;
	}

	public EventoEntity setGimnasioDTO(GimnasioEntity gimnasioEntity) {
		this.gimnasioEntity = UtilObject.getDefault(gimnasioEntity, GimnasioEntity.create());return this;
	}

}
