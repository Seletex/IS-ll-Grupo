package co.edu.uco.transformate.dto;

import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class EquipoDTO {

	private UUID identificador;
	private String nombre;
	private String descripcion;
	private ZonaDTO zonaDTO;

	public EquipoDTO(UUID identificador, String nombre, String descripcion, ZonaDTO zonaDTO) {
		super();
		setIdentificador(identificador);
		setNombre(nombre);
		setDescripcion(descripcion);
		setZonaDTO(zonaDTO);

	}

	public static EquipoDTO create() {
		return new EquipoDTO();
	}

	public EquipoDTO() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setZonaDTO(ZonaDTO.create());
		setNombre(UtilText.getDefaultValue());
		setDescripcion(UtilText.EMPTY);
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	public final EquipoDTO setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public final String getNombre() {
		return nombre;
	}

	public final EquipoDTO setNombre(String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
		return this;
	}

	public final String getDescripcion() {
		return descripcion;
	}

	public final EquipoDTO setDescripcion(String descripcion) {
		this.descripcion = UtilText.getUtilText().applyTrim(descripcion);
		return this;
	}

	public final ZonaDTO getZonaDTO() {
		return zonaDTO;
	}

	public final EquipoDTO setZonaDTO(ZonaDTO zonaDTO) {
		this.zonaDTO =  UtilObject.getDefault(zonaDTO, ZonaDTO.create());
		return this;
	}

}
