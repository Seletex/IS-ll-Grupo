package co.edu.uco.transformate.entities;

import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class OjetivoPlanEntity {

	private UUID identificador;
	private String nombre;
	private String descripcion;
	private PlanEntrenamientoEntity planEntrenamientoEntity;
	private ObjetivoEntrenamientoEntity objetivoEntrenamientoEntity;

	public OjetivoPlanEntity(UUID identificador, String nombre, ObjetivoEntrenamientoEntity objetivoEntrenamientoEntity,
			String descripcion, PlanEntrenamientoEntity planEntrenamientoEntity) {
		setDescripcion(descripcion);
		setObjetivoEntrenamientoDTO(objetivoEntrenamientoEntity);
		setPlanEntrenamientoDTO(planEntrenamientoEntity);
		setIdentificador(identificador);
		setNombre(nombre);
	}

	public OjetivoPlanEntity() {
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setNombre(UtilText.getDefaultValue());
		setDescripcion(UtilText.EMPTY);
		setObjetivoEntrenamientoDTO(ObjetivoEntrenamientoEntity.create());
		setPlanEntrenamientoDTO(PlanEntrenamientoEntity.create());

	}

	public static OjetivoPlanEntity create() {
		return new OjetivoPlanEntity();
	}

	public String getDescripcion() {
		return descripcion;
	}

	public OjetivoPlanEntity setDescripcion(String descripcion) {
		this.descripcion = UtilText.getUtilText().applyTrim(descripcion);
		return this;
	}

	public PlanEntrenamientoEntity getPlanEntrenamientoDTO() {
		return planEntrenamientoEntity;
	}

	public OjetivoPlanEntity setPlanEntrenamientoDTO(PlanEntrenamientoEntity planEntrenamientoEntity) {
		this.planEntrenamientoEntity = UtilObject.getDefault(planEntrenamientoEntity, PlanEntrenamientoEntity.create());
		return this;
	}

	public ObjetivoEntrenamientoEntity getObjetivoEntrenamientoDTO() {
		return objetivoEntrenamientoEntity;
	}

	public OjetivoPlanEntity setObjetivoEntrenamientoDTO(ObjetivoEntrenamientoEntity objetivoEntrenamientoEntity) {
		this.objetivoEntrenamientoEntity = UtilObject.getDefault(objetivoEntrenamientoEntity,
				ObjetivoEntrenamientoEntity.create());
		return this;
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	public final OjetivoPlanEntity setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public final String getNombre() {
		return nombre;
	}

	public final OjetivoPlanEntity setNombre(String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
		return this;
	}
}
