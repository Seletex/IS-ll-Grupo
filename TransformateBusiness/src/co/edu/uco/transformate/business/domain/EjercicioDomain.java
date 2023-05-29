package co.edu.uco.transformate.business.domain;


import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class EjercicioDomain {

	private UUID identi;
	private String nombre;
	private String descripcion;
	private EquipoDomain equipoDomain;
	private int repeticiones;
	private int series;

	private static final EjercicioDomain DEFAULT_OBJECT = new EjercicioDomain();

	public static EjercicioDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static EjercicioDomain create(UUID identicador, String nombre, String descripcion, EquipoDomain equipoDomain,
			int repeticiones, int series) {
		return new EjercicioDomain(identicador, nombre, descripcion, equipoDomain, repeticiones,series);
	}

	public  EjercicioDomain(UUID identicador, String nombre, String descripcion, EquipoDomain equipoDomain,
			int repeticiones, int series) {
		
		setIdenti(identicador);
		setNombre(nombre);
		setDescripcion(descripcion);
		setEquipoDTO(equipoDomain);
		setRepeticiones(repeticiones);
		setSeries(series);

	}

	private EjercicioDomain() {
		
		setIdenti(UtilUUID.DEFAULT_UUID);

		setEquipoDTO(EquipoDomain.getDefaultObject());
		setNombre(UtilText.getDefaultValue());
		setDescripcion(UtilText.EMPTY);

	}


	public final UUID getIdenti() {
		return identi;
	}

	private final void setIdenti(UUID identi) {
		this.identi = UtilUUID.getDefault(identi);
	
	}

	public final String getNombre() {
		return nombre;
	}

	private final void setNombre(String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
	
	}

	public final String getDescripcion() {
		return descripcion;
	}

	private final void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
		
	}

	public final EquipoDomain getEquipoDTO() {
		return equipoDomain;
	}

	private final void setEquipoDTO(EquipoDomain equipoDomain) {
		this.equipoDomain = UtilObject.getDefault(equipoDomain, EquipoDomain.getDefaultObject());
	
	}

	public final int getRepeticiones() {
		return repeticiones;
	}

	private final void setRepeticiones(int repeticiones) {
		this.repeticiones = repeticiones;
	
	}

	public final int getSeries() {
		return series;
	}

	private final void setSeries(int series) {
		this.series = series;
		
	}

}
