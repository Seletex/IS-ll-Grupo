package co.edu.uco.transformate.dto;

import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class ZonaDTO {

	private UUID identificador;
	private String nombre;
	private String descripcion;
	private GimnasioDTO gimnasioDTO;

	public ZonaDTO(UUID identificador, String nombre, String descripcion, GimnasioDTO gimnasioDTO) {
		super();
		setIdentificador(identificador);
		setNombre(nombre);
		setDescripcion(descripcion);
		setGimnasioDTO(gimnasioDTO);

	}

	public ZonaDTO() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setGimnasioDTO(GimnasioDTO.create());
		setNombre(UtilText.getDefaultValue());
		setDescripcion(UtilText.EMPTY);
	}

	public static ZonaDTO create() {
		return new ZonaDTO();
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	public final ZonaDTO setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public final String getNombre() {
		return nombre;
	}

	public final ZonaDTO setNombre(String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
		return this;
	}

	public final String getDescripcion() {
		return descripcion;
	}

	public final ZonaDTO setDescripcion(String descripcion) {
		this.descripcion = UtilText.getUtilText().applyTrim(descripcion);
		return this;
	}

	public final GimnasioDTO getGimnasioDTO() {
		return gimnasioDTO;
	}

	public final ZonaDTO setGimnasioDTO(GimnasioDTO gimnasioDTO) {
		this.gimnasioDTO = UtilObject.getDefault(gimnasioDTO, GimnasioDTO.create());
		return this;
	}

}
