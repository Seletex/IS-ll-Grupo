package co.edu.uco.transformate.business.domain;


import java.time.LocalDateTime;
import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilDate;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class GimnasioDomain {

	private UUID identificador;
	private String nombre;
	private String descripcionString;
	private String telefonoString;
	private String correoString;
	private LocalDateTime horaAperturaDate;
	private LocalDateTime horaCierreDate;
	
	private static final GimnasioDomain DEFAULT_OBJECT = new GimnasioDomain();

	public static GimnasioDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static GimnasioDomain create(UUID identificador, String nombre, String descripcionString, String telefonoString,
			String correoString, LocalDateTime horaAperturaDate, LocalDateTime horaCierreDate) {
		return new GimnasioDomain(identificador,nombre,descripcionString,telefonoString,correoString,horaAperturaDate,horaCierreDate);
	}

	public  GimnasioDomain(UUID identificador, String nombre, String descripcionString, String telefonoString,
			String correoString, LocalDateTime horaAperturaDate, LocalDateTime horaCierreDate) {
		
		setIdentificador(identificador);
		setNombre(nombre);
		setDescripcionString(descripcionString);
		setTelefonoString(telefonoString);
		setCorreoString(correoString);
		setHoraAperturaDate(horaAperturaDate);
		setHoraCierreDate(horaCierreDate);
	}

	private GimnasioDomain() {
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setNombre(UtilText.getDefaultValue());
		setDescripcionString(UtilText.EMPTY);
		setCorreoString(UtilText.EMPTY);
		setTelefonoString(UtilText.EMPTY);
		setHoraAperturaDate(UtilDate.DEFAULT_DATE_TIME);
		setHoraCierreDate(UtilDate.DEFAULT_DATE_TIME);

	}



	public final UUID getIdentificador() {
		return identificador;
	}

	private final void setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
	
	}

	public final String getNombre() {
		return nombre;
	}

	private final void setNombre(String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);

	}

	public final String getDescripcionString() {
		return descripcionString;
	}

	private final void setDescripcionString(String descripcionString) {
		this.descripcionString = UtilText.getUtilText().applyTrim(descripcionString);

	}

	public final String getTelefonoString() {
		return telefonoString;
	}

	private final void setTelefonoString(String telefonoString) {
		this.telefonoString = UtilText.getUtilText().applyTrim(telefonoString);

	}

	public final String getCorreoString() {
		return correoString;
	}

	private final void setCorreoString(String correoString) {
		this.correoString = UtilText.getUtilText().applyTrim(correoString);
	
	}

	public final LocalDateTime getHoraAperturaDate() {
		return horaAperturaDate;
	}

	private final void setHoraAperturaDate(LocalDateTime horaAperturaDate) {
		this.horaAperturaDate = UtilDate.getDefaultTime(horaAperturaDate);
	
	}

	public final LocalDateTime getHoraCierreDate() {
		return horaCierreDate;
	}

	private final void setHoraCierreDate(LocalDateTime defaultDateTime) {
		this.horaCierreDate = UtilDate.getDefaultTime(defaultDateTime);


	}

}
