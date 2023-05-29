package co.edu.uco.transformate.business.domain;


import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class PlanEntrenamientoDomain {

	private UUID identificador;
	private String nombre;
	private String descripcion;
	private NivelDificultadDomain nivel;

	private static final PlanEntrenamientoDomain DEFAULT_OBJECT = new PlanEntrenamientoDomain();

	public static PlanEntrenamientoDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static PlanEntrenamientoDomain create(UUID identificador, String nombre, String descripcion,
			NivelDificultadDomain nivel) {
		return new PlanEntrenamientoDomain(identificador, nombre, descripcion, nivel);
	}

	public PlanEntrenamientoDomain(UUID identificador, String nombre, String descripcion, NivelDificultadDomain nivel) {
	
		setIdentificador(identificador);
		setNombre(nombre);
		setDescripcion(descripcion);
		setNivel(nivel);

	}

	private PlanEntrenamientoDomain() {
		
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setDescripcion(UtilText.EMPTY);
		setNombre(UtilText.getDefaultValue());
		setNivel(NivelDificultadDomain.getDefaultObject());
	}

	public final String getDescripcion() {
		return descripcion;
	}

	private final void setDescripcion(String descripcion) {
		this.descripcion = UtilText.getUtilText().applyTrim(descripcion);
	
	}

	public final NivelDificultadDomain getNivel() {
		return nivel;
	}

	private final void setNivel(NivelDificultadDomain nivel) {
		this.nivel = UtilObject.getDefault(nivel, NivelDificultadDomain.getDefaultObject());
	
	}

	public static PlanEntrenamientoDomain create() {
		return new PlanEntrenamientoDomain();
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
