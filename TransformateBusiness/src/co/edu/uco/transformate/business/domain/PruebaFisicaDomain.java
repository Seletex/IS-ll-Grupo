package co.edu.uco.transformate.business.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilDate;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class PruebaFisicaDomain {

	private UUID identificadorUuid;
	private String descripcionString;
	private LocalDateTime tiempoDateTime;


	private static final PruebaFisicaDomain DEFAULT_OBJECT = new PruebaFisicaDomain();

	public static PruebaFisicaDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static PruebaFisicaDomain create(UUID identificadorUuid, String descripcionString, LocalDateTime tiempoDateTime
			) {
		return new PruebaFisicaDomain(identificadorUuid,descripcionString,tiempoDateTime);
	}
	
	public PruebaFisicaDomain(UUID identificadorUuid, String descripcionString, LocalDateTime tiempoDateTime) {
	
		setIdentificadorUuid(identificadorUuid);
		setDescripcionString(descripcionString);
		setTiempoDateTime(tiempoDateTime);

	}

	private PruebaFisicaDomain() {
	
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
