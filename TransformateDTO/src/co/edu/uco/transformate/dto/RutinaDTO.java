package co.edu.uco.transformate.dto;

import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class RutinaDTO {

	private UUID identificador;
	private String nombre;
	private String descripcion;
	private PlanEntrenamientoDTO planEntrenamientoDTO;
	private EjercicioDTO ejercicioDTO;
	private TipoRutinaDTO tipoRutinaDTO;

	public RutinaDTO(UUID identificador, String nombre, String descripcion, PlanEntrenamientoDTO planEntrenamientoDTO,
			EjercicioDTO ejercicioDTO, TipoRutinaDTO tipoRutinaDTO) {

		setIdentificador(identificador);
		setNombre(nombre);
		setDescripcion(descripcion);
		setPlanEntrenamientoDTO(planEntrenamientoDTO);
		setEjercicioDTO(ejercicioDTO);
		setTipoRutinaDTO(tipoRutinaDTO);
	}

	public static RutinaDTO create() {
		return new RutinaDTO();
	}

	public RutinaDTO() {
		super();

		setIdentificador(UtilUUID.DEFAULT_UUID);

		setNombre(UtilText.getDefaultValue());
		setDescripcion(UtilText.EMPTY);
		setPlanEntrenamientoDTO(PlanEntrenamientoDTO.create());
		setEjercicioDTO(EjercicioDTO.create());
		setTipoRutinaDTO(TipoRutinaDTO.create());

	}

	public UUID getIdentificador() {
		return identificador;
	}

	public RutinaDTO setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public String getNombre() {
		return nombre;
	}

	public RutinaDTO setNombre(String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
		return this;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public RutinaDTO setDescripcion(String descripcion) {
		this.descripcion = UtilText.getUtilText().applyTrim(descripcion);
		return this;
	}

	public PlanEntrenamientoDTO getPlanEntrenamientoDTO() {
		return planEntrenamientoDTO;
	}

	public RutinaDTO setPlanEntrenamientoDTO(PlanEntrenamientoDTO planEntrenamientoDTO) {
		this.planEntrenamientoDTO = UtilObject.getDefault(planEntrenamientoDTO, PlanEntrenamientoDTO.create());
		return this;
	}

	public EjercicioDTO getEjercicioDTO() {
		return ejercicioDTO;
	}

	public RutinaDTO setEjercicioDTO(EjercicioDTO ejercicioDTO) {
		this.ejercicioDTO = UtilObject.getDefault(ejercicioDTO, EjercicioDTO.create());
		return this;
	}

	public TipoRutinaDTO getTipoRutinaDTO() {
		return tipoRutinaDTO;
	}

	public RutinaDTO setTipoRutinaDTO(TipoRutinaDTO tipoRutinaDTO) {
		this.tipoRutinaDTO = UtilObject.getDefault(tipoRutinaDTO, TipoRutinaDTO.create());
		return this;
	}

}
