package co.edu.uco.transformate.dto;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilDate;
import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class ProgresoDTO {
	




	private LocalDate fecha;
	private UUID identificador;
	private MiembroDTO miembroDTO;
	private String descripcion;
	
	public ProgresoDTO(UUID identificador, String nombre,MiembroDTO miembroDTO,LocalDate fecha) {
		super();
		setIdentificador(identificador);
		setDescripcion(nombre);
		setMiembroDTO(miembroDTO);
setFecha(fecha);
	}

	public ProgresoDTO() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setMiembroDTO(MiembroDTO.create());
		setDescripcion(UtilText.getDefaultValue());
		setFecha(UtilDate.DEFAULT_DATE);
	}

	public static ProgresoDTO create() {
		return new ProgresoDTO();
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	public final ProgresoDTO setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public final String getDescripcion() {
		return descripcion;
	}

	public final ProgresoDTO setDescripcion(String nombre) {
		this.descripcion = UtilText.getUtilText().applyTrim(nombre);
		return this;
	}

	public MiembroDTO getMiembroDTO() {
		return miembroDTO;
	}

	public ProgresoDTO setMiembroDTO(MiembroDTO miembroDTO) {
		this.miembroDTO = UtilObject.getDefault(miembroDTO,MiembroDTO.create());return this;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = UtilDate.getDefault(fecha);
	}

}
