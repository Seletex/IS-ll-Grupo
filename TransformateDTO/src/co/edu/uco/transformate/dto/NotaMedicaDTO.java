package co.edu.uco.transformate.dto;

import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class NotaMedicaDTO {
	
	private UUID identificador;
	private MiembroDTO miembroDTO;
	private String descripcion;
	
	public NotaMedicaDTO(UUID identificador, String nombre,MiembroDTO miembroDTO) {
		super();
		setIdentificador(identificador);
		setDescripcion(nombre);
		setMiembroDTO(miembroDTO);

	}

	public NotaMedicaDTO() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setMiembroDTO(MiembroDTO.create());
		setDescripcion(UtilText.getDefaultValue());
		
	}

	public static NotaMedicaDTO create() {
		return new NotaMedicaDTO();
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	public final NotaMedicaDTO setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public final String getDescripcion() {
		return descripcion;
	}

	public final NotaMedicaDTO setDescripcion(String nombre) {
		this.descripcion = UtilText.getUtilText().applyTrim(nombre);
		return this;
	}

	public MiembroDTO getMiembroDTO() {
		return miembroDTO;
	}

	public NotaMedicaDTO setMiembroDTO(MiembroDTO miembroDTO) {
		this.miembroDTO = UtilObject.getDefault(miembroDTO,MiembroDTO.create());return this;
	}

}
