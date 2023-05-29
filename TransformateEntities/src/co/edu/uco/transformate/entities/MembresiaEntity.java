package co.edu.uco.transformate.entities;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilDate;

import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class MembresiaEntity {

	private UUID identificador;
	private TipoMembresiaEntity tipoMembresiaEntity;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	
	
	
	private static final MembresiaEntity DEFAULT_OBJECT = new MembresiaEntity();

	public static MembresiaEntity getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static MembresiaEntity create(UUID identificador, TipoMembresiaEntity tipoMembresiaEntity, LocalDate fechaInicio,
			LocalDate fechaFin) {
		return new MembresiaEntity(identificador,tipoMembresiaEntity,fechaInicio,fechaFin);
	}
	
	public MembresiaEntity(UUID identificador, TipoMembresiaEntity tipoMembresiaEntity, LocalDate fechaInicio,
			LocalDate fechaFin) {
		
		setFechaFin(fechaFin);
		setFechaInicio(fechaInicio);
		setIdentificador(identificador);
		setTipoMembresiaDTO(tipoMembresiaEntity);
	}

	private MembresiaEntity() {
		setFechaFin(UtilDate.DEFAULT_DATE);
		setFechaInicio(UtilDate.DEFAULT_DATE);
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setTipoMembresiaDTO(TipoMembresiaEntity.getDefaultObject());
		
	
	}




	
	public UUID getIdentificador() {
		return identificador;
	}

	public void setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
	}

	public TipoMembresiaEntity getTipoMembresiaDTO() {
		return tipoMembresiaEntity;
	}

	public void setTipoMembresiaDTO(TipoMembresiaEntity tipoMembresiaEntity) {
		this.tipoMembresiaEntity = UtilObject.getDefault(tipoMembresiaEntity, TipoMembresiaEntity.getDefaultObject());
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	

	
	
}
