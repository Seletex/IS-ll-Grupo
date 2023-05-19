package co.edu.uco.transformate.dto;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilDate;
import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class EventoDTO {

	private UUID identificador;
	private String descripcionString;
	private LocalDate fechaInicioDate;
	private LocalDate fechaFinDate;
	private GimnasioDTO gimnasioDTO;

	public EventoDTO(GimnasioDTO gimnasioDTO, UUID identificador, String descripcionString, LocalDate fechaInicioDate,
			LocalDate fechaFinDate) {
		super();
		setDescripcionString(descripcionString);
		setFechaFinDate(fechaFinDate);
		setFechaInicioDate(fechaInicioDate);
		setGimnasioDTO(gimnasioDTO);
		setIdentificador(identificador);
	}

	public EventoDTO() {
		super();
		setDescripcionString(UtilText.getDefaultValue());
		setFechaFinDate(UtilDate.DEFAULT_DATE);
		setFechaInicioDate(UtilDate.DEFAULT_DATE);
		setGimnasioDTO(GimnasioDTO.create());
		setIdentificador(UtilUUID.DEFAULT_UUID);
	}

	public static EventoDTO create() {
		return new EventoDTO();
	}

	public UUID getIdentificador() {
		return identificador;
	}

	public EventoDTO setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);return this;
	}

	public String getDescripcionString() {
		return descripcionString;
	}

	public EventoDTO setDescripcionString(String descripcionString) {
		this.descripcionString = UtilText.getUtilText().applyTrim(descripcionString);return this;
	}

	public LocalDate getFechaInicioDate() {
		return fechaInicioDate;
	}

	public EventoDTO setFechaInicioDate(LocalDate fechaInicioDate) {
		this.fechaInicioDate = UtilDate.getDefault(fechaInicioDate);return this;
	}

	public LocalDate getFechaFinDate() {
		return fechaFinDate;
	}

	public EventoDTO setFechaFinDate(LocalDate fechaFinDate) {
		this.fechaFinDate = UtilDate.getDefault(fechaFinDate);return this;
	}

	public GimnasioDTO getGimnasioDTO() {
		return gimnasioDTO;
	}

	public EventoDTO setGimnasioDTO(GimnasioDTO gimnasioDTO) {
		this.gimnasioDTO = UtilObject.getDefault(gimnasioDTO, GimnasioDTO.create());return this;
	}

}
