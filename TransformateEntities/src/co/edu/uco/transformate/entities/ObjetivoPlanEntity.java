package co.edu.uco.transformate.entities;


import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class ObjetivoPlanEntity {

	private UUID identificador;
	private String nombre;
	private String descripcion;
	private PlanEntrenamientoEntity planEntrenamientoEntity;
	private ObjetivoEntrenamientoEntity objetivoEntrenamientoEntity;

	private static final ObjetivoPlanEntity DEFAULT_OBJECT = new ObjetivoPlanEntity();

	public static ObjetivoPlanEntity getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static ObjetivoPlanEntity create(UUID identificador, String nombre,
			ObjetivoEntrenamientoEntity objetivoEntrenamientoEntity, String descripcion,
			PlanEntrenamientoEntity planEntrenamientoEntity) {
		return new ObjetivoPlanEntity(identificador, nombre, objetivoEntrenamientoEntity,descripcion,planEntrenamientoEntity);
	}

	public ObjetivoPlanEntity(UUID identificador, String nombre, ObjetivoEntrenamientoEntity objetivoEntrenamientoEntity,
			String descripcion, PlanEntrenamientoEntity planEntrenamientoEntity) {
		setDescripcion(descripcion);
		setObjetivoEntrenamientoDTO(objetivoEntrenamientoEntity);
		setPlanEntrenamientoDTO(planEntrenamientoEntity);
		setIdentificador(identificador);
		setNombre(nombre);
	}

	private ObjetivoPlanEntity() {
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setNombre(UtilText.getDefaultValue());
		setDescripcion(UtilText.EMPTY);
		setObjetivoEntrenamientoDTO(ObjetivoEntrenamientoEntity.getDefaultObject());
		setPlanEntrenamientoDTO(PlanEntrenamientoEntity.getDefaultObject());

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
		this.planEntrenamientoEntity = UtilObject.getDefault(planEntrenamientoEntity, PlanEntrenamientoEntity.getDefaultObject());
	
	}

	public ObjetivoEntrenamientoEntity getObjetivoEntrenamientoDTO() {
		return objetivoEntrenamientoEntity;
	}

	private void setObjetivoEntrenamientoDTO(ObjetivoEntrenamientoEntity objetivoEntrenamientoEntity) {
		this.objetivoEntrenamientoEntity = UtilObject.getDefault(objetivoEntrenamientoEntity,
				ObjetivoEntrenamientoEntity.getDefaultObject());
	
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	private void setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		
	}

	public final String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
		
	}
}
