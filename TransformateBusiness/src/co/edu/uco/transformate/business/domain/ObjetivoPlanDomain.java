package co.edu.uco.transformate.business.domain;


import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class ObjetivoPlanDomain {

	private UUID identificador;
	private String nombre;
	private String descripcion;
	private PlanEntrenamientoDomain planEntrenamientoDomain;
	private ObjetivoEntrenamientoDomain objetivoEntrenamientoDomain;

	private static final ObjetivoPlanDomain DEFAULT_OBJECT = new ObjetivoPlanDomain();

	public static ObjetivoPlanDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static ObjetivoPlanDomain create(UUID identificador, String nombre,
			ObjetivoEntrenamientoDomain objetivoEntrenamientoDomain, String descripcion,
			PlanEntrenamientoDomain planEntrenamientoDomain) {
		return new ObjetivoPlanDomain(identificador, nombre, objetivoEntrenamientoDomain,descripcion,planEntrenamientoDomain);
	}

	public ObjetivoPlanDomain(UUID identificador, String nombre, ObjetivoEntrenamientoDomain objetivoEntrenamientoDomain,
			String descripcion, PlanEntrenamientoDomain planEntrenamientoDomain) {
		setDescripcion(descripcion);
		setObjetivoEntrenamientoDTO(objetivoEntrenamientoDomain);
		setPlanEntrenamientoDTO(planEntrenamientoDomain);
		setIdentificador(identificador);
		setNombre(nombre);
	}

	private ObjetivoPlanDomain() {
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setNombre(UtilText.getDefaultValue());
		setDescripcion(UtilText.EMPTY);
		setObjetivoEntrenamientoDTO(ObjetivoEntrenamientoDomain.getDefaultObject());
		setPlanEntrenamientoDTO(PlanEntrenamientoDomain.getDefaultObject());

	}

	public static ObjetivoPlanDomain create() {
		return new ObjetivoPlanDomain();
	}

	public String getDescripcion() {
		return descripcion;
	}

	private void setDescripcion(String descripcion) {
		this.descripcion = UtilText.getUtilText().applyTrim(descripcion);
		
	}

	public PlanEntrenamientoDomain getPlanEntrenamientoDTO() {
		return planEntrenamientoDomain;
	}

	private void setPlanEntrenamientoDTO(PlanEntrenamientoDomain planEntrenamientoDomain) {
		this.planEntrenamientoDomain = UtilObject.getDefault(planEntrenamientoDomain, PlanEntrenamientoDomain.getDefaultObject());
	
	}

	public ObjetivoEntrenamientoDomain getObjetivoEntrenamientoDTO() {
		return objetivoEntrenamientoDomain;
	}

	private void setObjetivoEntrenamientoDTO(ObjetivoEntrenamientoDomain objetivoEntrenamientoDomain) {
		this.objetivoEntrenamientoDomain = UtilObject.getDefault(objetivoEntrenamientoDomain,
				ObjetivoEntrenamientoDomain.getDefaultObject());
	
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
