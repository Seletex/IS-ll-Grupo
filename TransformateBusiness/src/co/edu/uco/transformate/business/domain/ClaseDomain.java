package co.edu.uco.transformate.business.domain;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;


import co.edu.uco.transformate.crosscutting.utils.UtilDate;
import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public final class ClaseDomain {
	
	
	private UUID identificadorUuid;
	private LocalDate fechaDate;
	private LocalDateTime horaInicioDate;
	private LocalDateTime horaFinDate;
	private EntrenadorDomain entrenadorDomain;
	private static final ClaseDomain DEFAULT_OBJECT = new ClaseDomain();

	public static ClaseDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static ClaseDomain create(UUID identificadorUuid, LocalDate fechaDate, LocalDateTime horaInicioDate, LocalDateTime horaFinDate,
			EntrenadorDomain entrenadorDomain) {
		return new ClaseDomain(identificadorUuid,fechaDate,horaInicioDate,horaFinDate,entrenadorDomain);
	}
	
	public  ClaseDomain(UUID identificadorUuid, LocalDate fechaDate, LocalDateTime horaInicioDate, LocalDateTime horaFinDate,
			EntrenadorDomain entrenadorDomain) {
	
		setIdentificadorUuid(identificadorUuid);
		setFechaDate(fechaDate);
		setHoraInicioDate(horaInicioDate);
		setHoraFinDate(horaFinDate);
		setEntrenadorDTO(entrenadorDomain);
	}

	private ClaseDomain() {
		setIdentificadorUuid(UtilUUID.DEFAULT_UUID);
		setFechaDate(UtilDate.DEFAULT_DATE);
		setHoraInicioDate(UtilDate.DEFAULT_DATE_TIME);
		setHoraFinDate(UtilDate.DEFAULT_DATE_TIME);
		setEntrenadorDTO(EntrenadorDomain.create());
	}

	

	public final UUID getIdentificadorUuid() {
		return identificadorUuid;
	}

	private final void setIdentificadorUuid(UUID identificadorUuid) {
		this.identificadorUuid = UtilUUID.getDefault(identificadorUuid);
		
	}

	public final LocalDate getFechaDate() {
		return fechaDate;
	}

	private final void setFechaDate(LocalDate defaultDate) {
		this.fechaDate = UtilDate.getDefault(defaultDate);
	
	}

	public final LocalDateTime getHoraInicioDate() {
		return horaInicioDate;
	}

	private final void setHoraInicioDate(LocalDateTime defaultDateTime) {
		this.horaInicioDate = UtilDate.getDefaultTime(defaultDateTime);
		
	}

	public final LocalDateTime getHoraFinDate() {
		return horaFinDate;
	}

	private final void setHoraFinDate(LocalDateTime horaFinDate) {
		this.horaFinDate = UtilDate.getDefaultTime(horaFinDate);
		
	}

	public EntrenadorDomain getEntrenadorDTO() {
		return entrenadorDomain;
	}

	private final void setEntrenadorDTO(EntrenadorDomain entrenadorDomain) {
		this.entrenadorDomain = UtilObject.getDefault(entrenadorDomain, EntrenadorDomain.create());
	}

}
