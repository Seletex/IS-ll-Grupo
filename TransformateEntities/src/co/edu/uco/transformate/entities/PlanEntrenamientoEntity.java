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

	public PlanEntrenamientoEntity(UUID identificador, String nombre, String descripcion, NivelDificultadEntity nivel) {
		super();
		setIdentificador(identificador);
		setNombre(nombre);

	}

	public PlanEntrenamientoEntity() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);

		setNombre(UtilText.getDefaultValue());

	}
	
	
	

	public final String getDescripcion() {
		return descripcion;
	}

	public final PlanEntrenamientoEntity setDescripcion(String descripcion) {
		this.descripcion = UtilText.getUtilText().applyTrim(descripcion);
		return this;
	}

	public final NivelDificultadEntity getNivel() {
		return nivel;
	}

	public final PlanEntrenamientoEntity setNivel(NivelDificultadEntity nivel) {
		this.nivel =  UtilObject.getDefault(nivel, NivelDificultadEntity.create());
		return this;
	}

	public static PlanEntrenamientoEntity create() {
		return new PlanEntrenamientoEntity();
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	public final PlanEntrenamientoEntity setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public final String getNombre() {
		return nombre;
	}

	public final PlanEntrenamientoEntity setNombre(String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
		return this;
	}

}
