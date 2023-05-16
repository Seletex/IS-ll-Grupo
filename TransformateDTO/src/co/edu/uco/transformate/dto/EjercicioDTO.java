package co.edu.uco.transformate.dto;

import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class EjercicioDTO {

	private UUID identi;
	private String nombre;
	private String descripcion;
	private EquipoDTO equipoDTO;
	private int repeticiones;
	private int series;

	public EjercicioDTO(UUID identicador, String nombre, String descripcion, EquipoDTO equipoDTO, int repeticiones,
			int series) {
		super();
		setIdenti(identicador);
		setNombre(nombre);
		setDescripcion(descripcion);
		setEquipoDTO(equipoDTO);
		setRepeticiones(repeticiones);
		setSeries(series);

	}

	public EjercicioDTO() {
		super();
		setIdenti(UtilUUID.DEFAULT_UUID);

		setEquipoDTO(EquipoDTO.create());
		setNombre(UtilText.getDefaultValue());
		setDescripcion(UtilText.EMPTY);

	}
	
	public static EjercicioDTO create() {
		return new EjercicioDTO();
	}

	public final UUID getIdenti() {
		return identi;
	}

	public final EjercicioDTO setIdenti(UUID identi) {
		this.identi = UtilUUID.getDefault(identi);
		return this;
	}

	public final String getNombre() {
		return nombre;
	}

	public final EjercicioDTO setNombre(String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
		return this;
	}

	public final String getDescripcion() {
		return descripcion;
	}

	public final EjercicioDTO setDescripcion(String descripcion) {
		this.descripcion = descripcion;
		return this;
	}

	public final EquipoDTO getEquipoDTO() {
		return equipoDTO;
	}

	public final EjercicioDTO setEquipoDTO(EquipoDTO equipoDTO) {
		this.equipoDTO = UtilObject.getDefault(equipoDTO, EquipoDTO.create());
		return this;
	}

	public final int getRepeticiones() {
		return repeticiones;
	}

	public final EjercicioDTO setRepeticiones(int repeticiones) {
		this.repeticiones = repeticiones;
		return this;
	}

	public final int getSeries() {
		return series;
	}

	public final EjercicioDTO setSeries(int series) {
		this.series = series;
		return this;
	}

}
