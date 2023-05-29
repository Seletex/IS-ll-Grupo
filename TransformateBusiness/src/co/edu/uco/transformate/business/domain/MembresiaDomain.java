package co.edu.uco.transformate.business.domain;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilDate;

import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class MembresiaDomain {

	private UUID identificador;
	private TipoMembresiaDomain tipoMembresiaDomain;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	
	
	
	private static final MembresiaDomain DEFAULT_OBJECT = new MembresiaDomain();

	public static MembresiaDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static MembresiaDomain create(UUID identificador, TipoMembresiaDomain tipoMembresiaDomain, LocalDate fechaInicio,
			LocalDate fechaFin) {
		return new MembresiaDomain(identificador,tipoMembresiaDomain,fechaInicio,fechaFin);
	}
	
	public MembresiaDomain(UUID identificador, TipoMembresiaDomain tipoMembresiaDomain, LocalDate fechaInicio,
			LocalDate fechaFin) {
		
		setFechaFin(fechaFin);
		setFechaInicio(fechaInicio);
		setIdentificador(identificador);
		setTipoMembresiaDTO(tipoMembresiaDomain);
	}

	private MembresiaDomain() {
		setFechaFin(UtilDate.DEFAULT_DATE);
		setFechaInicio(UtilDate.DEFAULT_DATE);
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setTipoMembresiaDTO(TipoMembresiaDomain.getDefaultObject());
		
	
	}




	
	public UUID getIdentificador() {
		return identificador;
	}

	public void setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
	}

	public TipoMembresiaDomain getTipoMembresiaDTO() {
		return tipoMembresiaDomain;
	}

	public void setTipoMembresiaDTO(TipoMembresiaDomain tipoMembresiaDomain) {
		this.tipoMembresiaDomain = UtilObject.getDefault(tipoMembresiaDomain, TipoMembresiaDomain.getDefaultObject());
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
