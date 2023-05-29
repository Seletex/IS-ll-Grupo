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

	private static final OjetivoPlanEntity DEFAULT_OBJECT = new OjetivoPlanEntity();

	public static OjetivoPlanEntity getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static OjetivoPlanEntity create(UUID identificador, String nombre,
			ObjetivoEntrenamientoEntity objetivoEntrenamientoEntity, String descripcion,
			PlanEntrenamientoEntity planEntrenamientoEntity) {
		return new OjetivoPlanEntity(identificador, nombre, objetivoEntrenamientoEntity,descripcion,planEntrenamientoEntity);
	}

	public OjetivoPlanEntity(UUID identificador, String nombre, ObjetivoEntrenamientoEntity objetivoEntrenamientoEntity,
			String descripcion, PlanEntrenamientoEntity planEntrenamientoEntity) {
		setDescripcion(descripcion);
		setObjetivoEntrenamientoDTO(objetivoEntrenamientoEntity);
		setPlanEntrenamientoDTO(planEntrenamientoEntity);
		setIdentificador(identificador);
		setNombre(nombre);
	}

	private OjetivoPlanEntity() {
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
