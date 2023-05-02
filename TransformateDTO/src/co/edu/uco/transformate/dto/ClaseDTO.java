package co.edu.uco.transformate.dto;

<<<<<<< HEAD

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilDate;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public final class ClaseDTO {
	private UUID identificadorUuid;
	private LocalDate fechaDate;
	private LocalDateTime horaInicioDate;
	private LocalDateTime horaFinDate;
	private EntrenadorDTO entrenadorDTO;

	public ClaseDTO(UUID identificadorUuid, LocalDate fechaDate, LocalDateTime horaInicioDate, LocalDateTime horaFinDate,
			EntrenadorDTO entrenadorDTO) {
		super();
		setIdentificadorUuid(identificadorUuid);
		setFechaDate(fechaDate);
		setHoraInicioDate(horaInicioDate);
		setHoraFinDate(horaFinDate);
		setEntrenadorDTO(entrenadorDTO);
	}

	public ClaseDTO() {
		setIdentificadorUuid(UtilUUID.DEFAULT_UUID);
		setFechaDate(UtilDate.DEFAULT_DATE);
		setHoraInicioDate(UtilDate.DEFAULT_DATE_TIME);
		setHoraFinDate(UtilDate.DEFAULT_DATE_TIME);
		setEntrenadorDTO(entrenadorDTO);
	}

	public static ClaseDTO create() {
		return new ClaseDTO();
	}

	public final UUID getIdentificadorUuid() {
		return identificadorUuid;
	}

	public final ClaseDTO setIdentificadorUuid(UUID identificadorUuid) {
		this.identificadorUuid = UtilUUID.getDefault(identificadorUuid);
		return this;
	}

	public final LocalDate getFechaDate() {
		return fechaDate;
	}

	public final ClaseDTO setFechaDate(LocalDate defaultDate) {
		this.fechaDate = defaultDate;
		return this;
	}

	public final LocalDateTime getHoraInicioDate() {
		return horaInicioDate;
	}

	public final ClaseDTO setHoraInicioDate(LocalDateTime defaultDateTime) {
		this.horaInicioDate = defaultDateTime;
		return this;
	}

	public final LocalDateTime getHoraFinDate() {
		return horaFinDate;
	}

	public final ClaseDTO setHoraFinDate(LocalDateTime horaFinDate) {
		this.horaFinDate = horaFinDate;
		return this;
	}

	public EntrenadorDTO getEntrenadorDTO() {
		return entrenadorDTO;
	}

	public void setEntrenadorDTO(EntrenadorDTO entrenadorDTO) {
		this.entrenadorDTO = entrenadorDTO;
	}
=======
public class ClaseDTO {
>>>>>>> e59f9511753ae4554cd6904fbcb0b53a7f37dccc

}
