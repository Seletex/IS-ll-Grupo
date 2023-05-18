package co.edu.uco.transformate.dto;

import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class OjetivoPlanDTO {

	private UUID identificador;
	private String nombre;
	private String descripcion;
	private PlanEntrenamientoDTO planEntrenamientoDTO;
	private ObjetivoEntrenamientoDTO objetivoEntrenamientoDTO;

	public OjetivoPlanDTO(UUID identificador, String nombre, ObjetivoEntrenamientoDTO objetivoEntrenamientoDTO,
			String descripcion, PlanEntrenamientoDTO planEntrenamientoDTO) {
		setDescripcion(descripcion);
		setObjetivoEntrenamientoDTO(objetivoEntrenamientoDTO);
		setPlanEntrenamientoDTO(planEntrenamientoDTO);
		setIdentificador(identificador);
		setNombre(nombre);
	}

	public OjetivoPlanDTO() {
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setNombre(UtilText.getDefaultValue());
		setDescripcion(UtilText.EMPTY);
		setObjetivoEntrenamientoDTO(ObjetivoEntrenamientoDTO.create());
		setPlanEntrenamientoDTO(PlanEntrenamientoDTO.create());

	}

	public static OjetivoPlanDTO create() {
		return new OjetivoPlanDTO();
	}

	public String getDescripcion() {
		return descripcion;
	}

	public OjetivoPlanDTO setDescripcion(String descripcion) {
		this.descripcion = UtilText.getUtilText().applyTrim(descripcion);
		return this;
	}

	public PlanEntrenamientoDTO getPlanEntrenamientoDTO() {
		return planEntrenamientoDTO;
	}

	public OjetivoPlanDTO setPlanEntrenamientoDTO(PlanEntrenamientoDTO planEntrenamientoDTO) {
		this.planEntrenamientoDTO = UtilObject.getDefault(planEntrenamientoDTO, PlanEntrenamientoDTO.create());
		return this;
	}

	public ObjetivoEntrenamientoDTO getObjetivoEntrenamientoDTO() {
		return objetivoEntrenamientoDTO;
	}

	public OjetivoPlanDTO setObjetivoEntrenamientoDTO(ObjetivoEntrenamientoDTO objetivoEntrenamientoDTO) {
		this.objetivoEntrenamientoDTO = UtilObject.getDefault(objetivoEntrenamientoDTO,
				ObjetivoEntrenamientoDTO.create());
		return this;
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	public final OjetivoPlanDTO setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public final String getNombre() {
		return nombre;
	}

	public final OjetivoPlanDTO setNombre(String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
		return this;
	}
}
