package co.edu.uco.transformate.entities;

import java.time.LocalDate;
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

	private static final RutinaEntity DEFAULT_OBJECT = new RutinaEntity();

	public static RutinaEntity getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static RutinaEntity create(UUID identificador, String nombre, String descripcion,
			PlanEntrenamientoEntity planEntrenamientoEntity, EjercicioEntity ejercicioEntity,
			TipoRutinaEntity tipoRutinaEntity) {
		return new RutinaEntity(identificador,nombre,descripcion,planEntrenamientoEntity,ejercicioEntity,tipoRutinaEntity);
	}

	private RutinaEntity(UUID identificador, String nombre, String descripcion,
			PlanEntrenamientoEntity planEntrenamientoEntity, EjercicioEntity ejercicioEntity,
			TipoRutinaEntity tipoRutinaEntity) {

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

	private RutinaEntity() {
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

	private void setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
	
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
	
	}

	public String getDescripcion() {
		return descripcion;
	}

	private void setDescripcion(String descripcion) {
		this.descripcion = UtilText.getUtilText().applyTrim(descripcion);
		
	}

	public PlanEntrenamientoEntity getPlanEntrenamientoDTO() {
		return planEntrenamientoEntity;
	}

	private void setPlanEntrenamientoDTO(PlanEntrenamientoEntity planEntrenamientoEntity) {
		this.planEntrenamientoEntity = UtilObject.getDefault(planEntrenamientoEntity, PlanEntrenamientoEntity.create());
	
	}

	public EjercicioEntity getEjercicioDTO() {
		return ejercicioEntity;
	}

	private void setEjercicioDTO(EjercicioEntity ejercicioEntity) {
		this.ejercicioEntity = UtilObject.getDefault(ejercicioEntity, EjercicioEntity.create());
	
	}

	public TipoRutinaEntity getTipoRutinaDTO() {
		return tipoRutinaEntity;
	}

	private void setTipoRutinaDTO(TipoRutinaEntity tipoRutinaEntity) {
		this.tipoRutinaEntity = UtilObject.getDefault(tipoRutinaEntity, TipoRutinaEntity.create());
	
	}

}
