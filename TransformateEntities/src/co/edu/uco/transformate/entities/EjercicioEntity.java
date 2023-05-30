package co.edu.uco.transformate.entities;


import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class EjercicioEntity {

	private UUID identi;
	private String nombre;
	private String descripcion;
	private EquipoEntity equipoEntity;
	private int repeticiones;
	private int series;

	private static final EjercicioEntity DEFAULT_OBJECT = new EjercicioEntity();

	public static EjercicioEntity getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static EjercicioEntity create(UUID identicador, String nombre, String descripcion, EquipoEntity equipoEntity,
			int repeticiones, int series) {
		return new EjercicioEntity(identicador, nombre, descripcion, equipoEntity, repeticiones,series);
	}

	public  EjercicioEntity(UUID identicador, String nombre, String descripcion, EquipoEntity equipoEntity,
			int repeticiones, int series) {
		
		setIdenti(identicador);
		setNombre(nombre);
		setDescripcion(descripcion);
		setEquipoDTO(equipoEntity);
		setRepeticiones(repeticiones);
		setSeries(series);

	}

	private EjercicioEntity() {
		
		setIdenti(UtilUUID.DEFAULT_UUID);

		setEquipoDTO(EquipoEntity.getDefaultObject());
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

	public final EquipoEntity getEquipoEntity() {
		return equipoEntity;
	}

	private final void setEquipoDTO(EquipoEntity equipoEntity) {
		this.equipoEntity = UtilObject.getDefault(equipoEntity, EquipoEntity.getDefaultObject());
	
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
