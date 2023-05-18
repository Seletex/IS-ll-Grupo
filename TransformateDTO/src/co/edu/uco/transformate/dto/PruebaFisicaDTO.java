package co.edu.uco.transformate.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilDate;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class PruebaFisicaDTO {
	
	private UUID identificadorUuid;
	private String descripcionString;
	private LocalDateTime tiempoDateTime;
	public PruebaFisicaDTO(UUID identificadorUuid, String descripcionString, LocalDateTime tiempoDateTime) {
		super();
		setIdentificadorUuid(identificadorUuid);
		setDescripcionString(descripcionString);
		setTiempoDateTime(tiempoDateTime);
		
	}
	public PruebaFisicaDTO() {
		super();
		setIdentificadorUuid(UtilUUID.DEFAULT_UUID);
		setDescripcionString(UtilText.getDefaultValue());
	}
	
	public static PruebaFisicaDTO create() {
		return new PruebaFisicaDTO();
	}
	public UUID getIdentificadorUuid() {
		return identificadorUuid;
	}
	public PruebaFisicaDTO setIdentificadorUuid(UUID identificadorUuid) {
		this.identificadorUuid = UtilUUID.getDefault(identificadorUuid);return this;
	}
	public String getDescripcionString() {
		return descripcionString;
	}
	public PruebaFisicaDTO setDescripcionString(String descripcionString) {
		this.descripcionString = UtilText.getUtilText().applyTrim(descripcionString);return this;
	}
	public LocalDateTime getTiempoDateTime() {
		return tiempoDateTime;
	}
	public PruebaFisicaDTO setTiempoDateTime(LocalDateTime tiempoDateTime) {
		this.tiempoDateTime = UtilDate.getDefaultTime(tiempoDateTime);return this;
	}

}
