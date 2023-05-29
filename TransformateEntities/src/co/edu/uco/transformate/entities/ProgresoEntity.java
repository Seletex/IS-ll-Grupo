package co.edu.uco.transformate.entities;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilDate;
import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class ProgresoEntity {
	




	private LocalDate fecha;
	private UUID identificador;
	private MiembroEntity miembroEntity;
	private String descripcion;
	

	private static final ProgresoEntity DEFAULT_OBJECT = new ProgresoEntity();

	public static ProgresoEntity getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static ProgresoEntity create(UUID identificador, String nombre,MiembroEntity miembroEntity,LocalDate fecha
			) {
		return new ProgresoEntity(identificador,nombre,miembroEntity,fecha);
	}
	
	public ProgresoEntity(UUID identificador, String nombre,MiembroEntity miembroEntity,LocalDate fecha) {
	
		setIdentificador(identificador);
		setDescripcion(nombre);
		setMiembroDTO(miembroEntity);
setFecha(fecha);
	}

	private ProgresoEntity() {

		setIdentificador(UtilUUID.DEFAULT_UUID);
		setMiembroDTO(MiembroEntity.getDefaultObject());
		setDescripcion(UtilText.getDefaultValue());
		setFecha(UtilDate.DEFAULT_DATE);
	}

	public static ProgresoEntity create() {
		return new ProgresoEntity();
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	private final void setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		
	}

	public final String getDescripcion() {
		return descripcion;
	}

	private void setDescripcion(String nombre) {
		this.descripcion = UtilText.getUtilText().applyTrim(nombre);
	
	}

	public MiembroEntity getMiembroDTO() {
		return miembroEntity;
	}

	private void setMiembroDTO(MiembroEntity miembroEntity) {
		this.miembroEntity = UtilObject.getDefault(miembroEntity,MiembroEntity.getDefaultObject());
	}

	public LocalDate getFecha() {
		return fecha;
	}

	private void setFecha(LocalDate fecha) {
		this.fecha = UtilDate.getDefault(fecha);
	}

}
