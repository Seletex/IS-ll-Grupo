package co.edu.uco.transformate.dto;


import java.time.LocalDateTime;
import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilDate;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class GimnasioDTO {

	private UUID identificador;
	private String nombre;
	private String descripcionString;
	private String telefonoString;
	private String correoString;
	private LocalDateTime horaAperturaDate;
	private LocalDateTime horaCierreDate;

	public GimnasioDTO(UUID identificador, String nombre, String descripcionString, String telefonoString,
			String correoString, LocalDateTime horaAperturaDate, LocalDateTime horaCierreDate) {
		super();
		setIdentificador(identificador);
		setNombre(nombre);
		setDescripcionString(descripcionString);
		setTelefonoString(telefonoString);
		setCorreoString(correoString);
		setHoraAperturaDate(horaAperturaDate);
		setHoraCierreDate(horaCierreDate);
	}

	public GimnasioDTO() {
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setNombre(UtilText.getDefaultValue());
		setDescripcionString(UtilText.EMPTY);
		setCorreoString(UtilText.EMPTY);
		setTelefonoString(UtilText.EMPTY);
		setHoraAperturaDate(UtilDate.DEFAULT_DATE_TIME);
		setHoraCierreDate(UtilDate.DEFAULT_DATE_TIME);

	}

	public static GimnasioDTO create() {
		return new GimnasioDTO();
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	public final GimnasioDTO setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public final String getNombre() {
		return nombre;
	}

	public final GimnasioDTO setNombre(String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
		return this;
	}

	public final String getDescripcionString() {
		return descripcionString;
	}

	public final GimnasioDTO setDescripcionString(String descripcionString) {
		this.descripcionString = UtilText.getUtilText().applyTrim(descripcionString);
		return this;
	}

	public final String getTelefonoString() {
		return telefonoString;
	}

	public final GimnasioDTO setTelefonoString(String telefonoString) {
		this.telefonoString = UtilText.getUtilText().applyTrim(telefonoString);
		return this;
	}

	public final String getCorreoString() {
		return correoString;
	}

	public final GimnasioDTO setCorreoString(String correoString) {
		this.correoString = UtilText.getUtilText().applyTrim(correoString);
		return this;
	}

	public final LocalDateTime getHoraAperturaDate() {
		return horaAperturaDate;
	}

	public final GimnasioDTO setHoraAperturaDate(LocalDateTime horaAperturaDate) {
		this.horaAperturaDate = UtilDate.getDefaultTime(horaAperturaDate);
		return this;
	}

	public final LocalDateTime getHoraCierreDate() {
		return horaCierreDate;
	}

	public final GimnasioDTO setHoraCierreDate(LocalDateTime defaultDateTime) {
		this.horaCierreDate = UtilDate.getDefaultTime(defaultDateTime);

return this;
	}

}
