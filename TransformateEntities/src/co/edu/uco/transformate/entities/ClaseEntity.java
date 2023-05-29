package co.edu.uco.transformate.entities;



import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;


import co.edu.uco.transformate.crosscutting.utils.UtilDate;
import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public final class ClaseEntity {
	
	
	private UUID identificadorUuid;
	private LocalDate fechaDate;
	private LocalDateTime horaInicioDate;
	private LocalDateTime horaFinDate;
	private EntrenadorEntity entrenadorEntity;
	private static final ClaseEntity DEFAULT_OBJECT = new ClaseEntity();

	public static ClaseEntity getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static ClaseEntity create(UUID identificadorUuid, LocalDate fechaDate, LocalDateTime horaInicioDate, LocalDateTime horaFinDate,
			EntrenadorEntity entrenadorEntity) {
		return new ClaseEntity(identificadorUuid,fechaDate,horaInicioDate,horaFinDate,entrenadorEntity);
	}
	
	public  ClaseEntity(UUID identificadorUuid, LocalDate fechaDate, LocalDateTime horaInicioDate, LocalDateTime horaFinDate,
			EntrenadorEntity entrenadorEntity) {
	
		setIdentificadorUuid(identificadorUuid);
		setFechaDate(fechaDate);
		setHoraInicioDate(horaInicioDate);
		setHoraFinDate(horaFinDate);
		setEntrenadorDTO(entrenadorEntity);
	}

	private ClaseEntity() {
		setIdentificadorUuid(UtilUUID.DEFAULT_UUID);
		setFechaDate(UtilDate.DEFAULT_DATE);
		setHoraInicioDate(UtilDate.DEFAULT_DATE_TIME);
		setHoraFinDate(UtilDate.DEFAULT_DATE_TIME);
		setEntrenadorDTO(EntrenadorEntity.create());
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

	public EntrenadorEntity getEntrenadorDTO() {
		return entrenadorEntity;
	}

	private final void setEntrenadorDTO(EntrenadorEntity entrenadorEntity) {
		this.entrenadorEntity = UtilObject.getDefault(entrenadorEntity, EntrenadorEntity.create());
	}

}
