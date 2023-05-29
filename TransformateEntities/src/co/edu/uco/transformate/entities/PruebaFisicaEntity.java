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


	private static final PruebaFisicaEntity DEFAULT_OBJECT = new PruebaFisicaEntity();

	public static PruebaFisicaEntity getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static PruebaFisicaEntity create(UUID identificadorUuid, String descripcionString, LocalDateTime tiempoDateTime
			) {
		return new PruebaFisicaEntity(identificadorUuid,descripcionString,tiempoDateTime);
	}
	
	public PruebaFisicaEntity(UUID identificadorUuid, String descripcionString, LocalDateTime tiempoDateTime) {
	
		setIdentificadorUuid(identificadorUuid);
		setDescripcionString(descripcionString);
		setTiempoDateTime(tiempoDateTime);

	}

	private PruebaFisicaEntity() {
	
		setIdentificadorUuid(UtilUUID.DEFAULT_UUID);
		setDescripcionString(UtilText.getDefaultValue());
	}



	public UUID getIdentificadorUuid() {
		return identificadorUuid;
	}

	private void setIdentificadorUuid(UUID identificadorUuid) {
		this.identificadorUuid = UtilUUID.getDefault(identificadorUuid);
		
	}

	public String getDescripcionString() {
		return descripcionString;
	}

	private void setDescripcionString(String descripcionString) {
		this.descripcionString = UtilText.getUtilText().applyTrim(descripcionString);
	
	}

	public LocalDateTime getTiempoDateTime() {
		return tiempoDateTime;
	}

	private void setTiempoDateTime(LocalDateTime tiempoDateTime) {
		this.tiempoDateTime = UtilDate.getDefaultTime(tiempoDateTime);
		
	}

}
