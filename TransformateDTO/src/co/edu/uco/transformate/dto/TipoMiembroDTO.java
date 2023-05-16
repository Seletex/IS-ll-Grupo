package co.edu.uco.transformate.dto;

import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class TipoMiembroDTO {
	private UUID identificador;
	private String nombre;
	private TipoDescuentoDTO tipoDescuentoDTO;

	public TipoMiembroDTO(UUID identificador, String nombre) {
		
		setIdentificador(identificador);
		setNombre(nombre);
		setTipoDescuentoDTO(tipoDescuentoDTO);

	}

	public TipoMiembroDTO() {
		
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setTipoDescuentoDTO(TipoDescuentoDTO.create());
		setNombre(UtilText.getDefaultValue());
		
	}

	public final TipoDescuentoDTO getTipoDescuentoDTO() {
		return tipoDescuentoDTO;
	}

	public final TipoMiembroDTO setTipoDescuentoDTO(TipoDescuentoDTO tipoDescuentoDTO) {
		this.tipoDescuentoDTO = UtilObject.getDefault(tipoDescuentoDTO, TipoDescuentoDTO.create());;
		return this;
	}

	public static TipoMiembroDTO create() {
		return new TipoMiembroDTO();
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	public final TipoMiembroDTO setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public final String getNombre() {
		return nombre;
	}

	public final TipoMiembroDTO setNombre(String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
		return this;
	}

}
