package co.edu.uco.transformate.dto;

import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class PlanEntrenamientoDTO {

	private UUID identificador;
	private String nombre;
	private String descripcion;
	private NivelDificultadDTO nivel;

	public PlanEntrenamientoDTO(UUID identificador, String nombre, String descripcion, NivelDificultadDTO nivel) {
		super();
		setIdentificador(identificador);
		setNombre(nombre);

	}

	public PlanEntrenamientoDTO() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);

		setNombre(UtilText.getDefaultValue());

	}
	
	
	

	public final String getDescripcion() {
		return descripcion;
	}

	public final PlanEntrenamientoDTO setDescripcion(String descripcion) {
		this.descripcion = UtilText.getUtilText().applyTrim(descripcion);
		return this;
	}

	public final NivelDificultadDTO getNivel() {
		return nivel;
	}

	public final PlanEntrenamientoDTO setNivel(NivelDificultadDTO nivel) {
		this.nivel =  UtilObject.getDefault(nivel, NivelDificultadDTO.create());
		return this;
	}

	public static PlanEntrenamientoDTO create() {
		return new PlanEntrenamientoDTO();
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	public final PlanEntrenamientoDTO setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public final String getNombre() {
		return nombre;
	}

	public final PlanEntrenamientoDTO setNombre(String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
		return this;
	}

}
