package co.edu.uco.transformate.dto;

import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class ObjetivoPlanDTO {

	private UUID identificador;
	private String nombre;
	private String descripcion;
	private PlanEntrenamientoDTO planEntrenamientoDTO;
	private ObjetivoEntrenamientoDTO objetivoEntrenamientoDTO;

	public ObjetivoPlanDTO(UUID identificador, String nombre, ObjetivoEntrenamientoDTO objetivoEntrenamientoDTO,
			String descripcion, PlanEntrenamientoDTO planEntrenamientoDTO) {
		setDescripcion(descripcion);
		setObjetivoEntrenamientoDTO(objetivoEntrenamientoDTO);
		setPlanEntrenamientoDTO(planEntrenamientoDTO);
		setIdentificador(identificador);
		setNombre(nombre);
	}

	public ObjetivoPlanDTO() {
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setNombre(UtilText.getDefaultValue());
		setDescripcion(UtilText.EMPTY);
		setObjetivoEntrenamientoDTO(ObjetivoEntrenamientoDTO.create());
		setPlanEntrenamientoDTO(PlanEntrenamientoDTO.create());

	}

	public static ObjetivoPlanDTO create() {
		return new ObjetivoPlanDTO();
	}

	public String getDescripcion() {
		return descripcion;
	}

	public ObjetivoPlanDTO setDescripcion(String descripcion) {
		this.descripcion = UtilText.getUtilText().applyTrim(descripcion);
		return this;
	}

	public PlanEntrenamientoDTO getPlanEntrenamientoDTO() {
		return planEntrenamientoDTO;
	}

	public ObjetivoPlanDTO setPlanEntrenamientoDTO(PlanEntrenamientoDTO planEntrenamientoDTO) {
		this.planEntrenamientoDTO = UtilObject.getDefault(planEntrenamientoDTO, PlanEntrenamientoDTO.create());
		return this;
	}

	public ObjetivoEntrenamientoDTO getObjetivoEntrenamientoDTO() {
		return objetivoEntrenamientoDTO;
	}

	public ObjetivoPlanDTO setObjetivoEntrenamientoDTO(ObjetivoEntrenamientoDTO objetivoEntrenamientoDTO) {
		this.objetivoEntrenamientoDTO = UtilObject.getDefault(objetivoEntrenamientoDTO,
				ObjetivoEntrenamientoDTO.create());
		return this;
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	public final ObjetivoPlanDTO setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public final String getNombre() {
		return nombre;
	}

	public final ObjetivoPlanDTO setNombre(String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
		return this;
	}
}
