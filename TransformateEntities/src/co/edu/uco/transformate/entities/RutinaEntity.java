package co.edu.uco.transformate.entities;

import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class RutinaEntity {

	private UUID identificador;
	private String nombre;
	private String descripcion;
	private PlanEntrenamientoEntity planEntrenamientoEntity;
	private EjercicioEntity ejercicioEntity;
	private TipoRutinaEntity tipoRutinaEntity;

	public RutinaEntity(UUID identificador, String nombre, String descripcion, PlanEntrenamientoEntity planEntrenamientoEntity,
			EjercicioEntity ejercicioEntity, TipoRutinaEntity tipoRutinaEntity) {

		setIdentificador(identificador);
		setNombre(nombre);
		setDescripcion(descripcion);
		setPlanEntrenamientoDTO(planEntrenamientoEntity);
		setEjercicioDTO(ejercicioEntity);
		setTipoRutinaDTO(tipoRutinaEntity);
	}

	public static RutinaEntity create() {
		return new RutinaEntity();
	}

	public RutinaEntity() {
		super();

		setIdentificador(UtilUUID.DEFAULT_UUID);

		setNombre(UtilText.getDefaultValue());
		setDescripcion(UtilText.EMPTY);
		setPlanEntrenamientoDTO(PlanEntrenamientoEntity.create());
		setEjercicioDTO(EjercicioEntity.create());
		setTipoRutinaDTO(TipoRutinaEntity.create());

	}

	public UUID getIdentificador() {
		return identificador;
	}

	public RutinaEntity setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public String getNombre() {
		return nombre;
	}

	public RutinaEntity setNombre(String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
		return this;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public RutinaEntity setDescripcion(String descripcion) {
		this.descripcion = UtilText.getUtilText().applyTrim(descripcion);
		return this;
	}

	public PlanEntrenamientoEntity getPlanEntrenamientoDTO() {
		return planEntrenamientoEntity;
	}

	public RutinaEntity setPlanEntrenamientoDTO(PlanEntrenamientoEntity planEntrenamientoEntity) {
		this.planEntrenamientoEntity = UtilObject.getDefault(planEntrenamientoEntity, PlanEntrenamientoEntity.create());
		return this;
	}

	public EjercicioEntity getEjercicioDTO() {
		return ejercicioEntity;
	}

	public RutinaEntity setEjercicioDTO(EjercicioEntity ejercicioEntity) {
		this.ejercicioEntity = UtilObject.getDefault(ejercicioEntity, EjercicioEntity.create());
		return this;
	}

	public TipoRutinaEntity getTipoRutinaDTO() {
		return tipoRutinaEntity;
	}

	public RutinaEntity setTipoRutinaDTO(TipoRutinaEntity tipoRutinaEntity) {
		this.tipoRutinaEntity = UtilObject.getDefault(tipoRutinaEntity, TipoRutinaEntity.create());
		return this;
	}

}
