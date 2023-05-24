package co.edu.uco.transformate.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilDate;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class PruebaFisicaEntity {
	
	private UUID identificadorUuid;
	private String descripcionString;
	private LocalDateTime tiempoDateTime;
	public PruebaFisicaEntity(UUID identificadorUuid, String descripcionString, LocalDateTime tiempoDateTime) {
		super();
		setIdentificadorUuid(identificadorUuid);
		setDescripcionString(descripcionString);
		setTiempoDateTime(tiempoDateTime);
		
	}
	public PruebaFisicaEntity() {
		super();
		setIdentificadorUuid(UtilUUID.DEFAULT_UUID);
		setDescripcionString(UtilText.getDefaultValue());
	}
	
	public static PruebaFisicaEntity create() {
		return new PruebaFisicaEntity();
	}
	public UUID getIdentificadorUuid() {
		return identificadorUuid;
	}
	public PruebaFisicaEntity setIdentificadorUuid(UUID identificadorUuid) {
		this.identificadorUuid = UtilUUID.getDefault(identificadorUuid);return this;
	}
	public String getDescripcionString() {
		return descripcionString;
	}
	public PruebaFisicaEntity setDescripcionString(String descripcionString) {
		this.descripcionString = UtilText.getUtilText().applyTrim(descripcionString);return this;
	}
	public LocalDateTime getTiempoDateTime() {
		return tiempoDateTime;
	}
	public PruebaFisicaEntity setTiempoDateTime(LocalDateTime tiempoDateTime) {
		this.tiempoDateTime = UtilDate.getDefaultTime(tiempoDateTime);return this;
	}

}
