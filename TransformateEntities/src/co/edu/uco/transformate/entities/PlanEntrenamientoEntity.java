package co.edu.uco.transformate.entities;


import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class PlanEntrenamientoEntity {

	private UUID identificador;
	private String nombre;
	private String descripcion;
	private NivelDificultadEntity nivel;

	private static final PlanEntrenamientoEntity DEFAULT_OBJECT = new PlanEntrenamientoEntity();

	public static PlanEntrenamientoEntity getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static PlanEntrenamientoEntity create(UUID identificador, String nombre, String descripcion,
			NivelDificultadEntity nivel) {
		return new PlanEntrenamientoEntity(identificador, nombre, descripcion, nivel);
	}

	public PlanEntrenamientoEntity(UUID identificador, String nombre, String descripcion, NivelDificultadEntity nivel) {
	
		setIdentificador(identificador);
		setNombre(nombre);
		setDescripcion(descripcion);
		setNivel(nivel);

	}

	private PlanEntrenamientoEntity() {
		
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setDescripcion(UtilText.EMPTY);
		setNombre(UtilText.getDefaultValue());
		setNivel(NivelDificultadEntity.getDefaultObject());
	}

	public final String getDescripcion() {
		return descripcion;
	}

	private final void setDescripcion(String descripcion) {
		this.descripcion = UtilText.getUtilText().applyTrim(descripcion);
	
	}

	public final NivelDificultadEntity getNivel() {
		return nivel;
	}

	private final void setNivel(NivelDificultadEntity nivel) {
		this.nivel = UtilObject.getDefault(nivel, NivelDificultadEntity.getDefaultObject());
	
	}

	public static PlanEntrenamientoEntity create() {
		return new PlanEntrenamientoEntity();
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	private final void setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);

	}

	public final String getNombre() {
		return nombre;
	}

	private final void setNombre(String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
	
	}

}
