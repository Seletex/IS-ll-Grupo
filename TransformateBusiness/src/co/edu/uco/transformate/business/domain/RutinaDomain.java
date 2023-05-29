package co.edu.uco.transformate.business.domain;


import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class RutinaDomain {

	private UUID identificador;
	private String nombre;
	private String descripcion;
	private PlanEntrenamientoDomain planEntrenamientoDomain;
	private EjercicioDomain ejercicioDomain;
	private TipoRutinaDomain tipoRutinaDomain;

	private static final RutinaDomain DEFAULT_OBJECT = new RutinaDomain();

	public static RutinaDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static RutinaDomain create(UUID identificador, String nombre, String descripcion,
			PlanEntrenamientoDomain planEntrenamientoDomain, EjercicioDomain ejercicioDomain,
			TipoRutinaDomain tipoRutinaDomain) {
		return new RutinaDomain(identificador,nombre,descripcion,planEntrenamientoDomain,ejercicioDomain,tipoRutinaDomain);
	}

	public RutinaDomain(UUID identificador, String nombre, String descripcion,
			PlanEntrenamientoDomain planEntrenamientoDomain, EjercicioDomain ejercicioDomain,
			TipoRutinaDomain tipoRutinaDomain) {

		setIdentificador(identificador);
		setNombre(nombre);
		setDescripcion(descripcion);
		setPlanEntrenamientoDTO(planEntrenamientoDomain);
		setEjercicioDTO(ejercicioDomain);
		setTipoRutinaDTO(tipoRutinaDomain);
	}

	

	private RutinaDomain() {
		

		setIdentificador(UtilUUID.DEFAULT_UUID);

		setNombre(UtilText.getDefaultValue());
		setDescripcion(UtilText.EMPTY);
		setPlanEntrenamientoDTO(PlanEntrenamientoDomain.create());
		setEjercicioDTO(EjercicioDomain.getDefaultObject());
		setTipoRutinaDTO(TipoRutinaDomain.getDefaultObject());

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

	public PlanEntrenamientoDomain getPlanEntrenamientoDTO() {
		return planEntrenamientoDomain;
	}

	private void setPlanEntrenamientoDTO(PlanEntrenamientoDomain planEntrenamientoDomain) {
		this.planEntrenamientoDomain = UtilObject.getDefault(planEntrenamientoDomain, PlanEntrenamientoDomain.getDefaultObject());
	
	}

	public EjercicioDomain getEjercicioDTO() {
		return ejercicioDomain;
	}

	private void setEjercicioDTO(EjercicioDomain ejercicioDomain) {
		this.ejercicioDomain = UtilObject.getDefault(ejercicioDomain, EjercicioDomain.getDefaultObject());
	
	}

	public TipoRutinaDomain getTipoRutinaDTO() {
		return tipoRutinaDomain;
	}

	private void setTipoRutinaDTO(TipoRutinaDomain tipoRutinaDomain) {
		this.tipoRutinaDomain = UtilObject.getDefault(tipoRutinaDomain, TipoRutinaDomain.getDefaultObject());
	
	}

}
