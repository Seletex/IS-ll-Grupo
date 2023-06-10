package co.edu.uco.transformate.dto;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilDate;

import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class MembresiaDTO {

	private UUID identificador;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private TipoMembresiaDTO tipoMembresiaDTO;
	
	
	
	
	public MembresiaDTO(UUID identificador, TipoMembresiaDTO tipoMembresiaDTO, LocalDate fechaInicio,
			LocalDate fechaFin) {
		
		setFechaFin(fechaFin);
		setFechaInicio(fechaInicio);
		setIdentificador(identificador);
		setTipoMembresiaDTO(tipoMembresiaDTO);
	}



	public MembresiaDTO() {
		
		setFechaFin(UtilDate.DEFAULT_DATE);
		setFechaInicio(UtilDate.DEFAULT_DATE);
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setTipoMembresiaDTO(TipoMembresiaDTO.create());
		
		
		
	}

	public static MembresiaDTO create() {
		return new MembresiaDTO();
	}

	
	public UUID getIdentificador() {
		return identificador;
	}

	public void setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
	}

	public TipoMembresiaDTO getTipoMembresiaDTO() {
		return tipoMembresiaDTO;
	}

	public void setTipoMembresiaDTO(TipoMembresiaDTO tipoMembresiaDTO) {
		this.tipoMembresiaDTO = UtilObject.getDefault(tipoMembresiaDTO, TipoMembresiaDTO.create());
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
