package co.edu.uco.transformate.entities;


import java.time.LocalDateTime;
import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilDate;
import co.edu.uco.transformate.crosscutting.utils.UtilNumber;
import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class EgresoEntity {
	
	private UUID identiUuid;
	private String nombre;
	private String descripcion;
	private int total;
	private LocalDateTime fecha;
	private GerenteEntity responsable;
	private TipoEgresoEntity tipoEgreso;

	private static final EgresoEntity DEFAULT_OBJECT = new EgresoEntity();

	public static EgresoEntity getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static EgresoEntity create(UUID identiUuid, String nombre, String descripcion, int total, LocalDateTime fecha,
	GerenteEntity responsable, TipoEgresoEntity tipoEgreso) {
		return new EgresoEntity(identiUuid,nombre,descripcion,total,fecha,responsable,tipoEgreso);
	}

	
	public  EgresoEntity(UUID identiUuid, String nombre, String descripcion, int total, LocalDateTime fecha,
			GerenteEntity responsable, TipoEgresoEntity tipoEgreso) {
		setIdentiUuid(identiUuid);
		setDescripcion(descripcion);
		setNombre(nombre);
		setTipoEgreso(tipoEgreso);
		setTotal(total);
		setFecha(fecha);
		setResponsable(responsable);
		
	}

	private EgresoEntity() {
		setIdentiUuid(UtilUUID.DEFAULT_UUID);
		setNombre(UtilText.getDefaultValue());
		setTipoEgreso(TipoEgresoEntity.getDefaultObject());
		setDescripcion(UtilText.EMPTY);
		setTotal(UtilNumber.ZERO);
		setFecha(UtilDate.DEFAULT_DATE_TIME);
		setResponsable(GerenteEntity.getDefaultObject());
	}
	


	public UUID getIdentiUuid() {
		return identiUuid;
	}

	private void setIdentiUuid(UUID identiUuid) {
		this.identiUuid = UtilUUID.getDefault(identiUuid);
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

	public int getTotal() {
		return total;
	}

	private void setTotal(int total) {
		this.total = UtilNumber.getDefaultNumber(total);
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	private void setFecha(LocalDateTime fecha) {
		this.fecha = UtilDate.getDefaultTime(fecha);
	}

	public GerenteEntity getResponsable() {
		return responsable;
	}

	private void setResponsable(GerenteEntity responsable) {
		this.responsable = UtilObject.getDefault(responsable, GerenteEntity.getDefaultObject());
	}

	public TipoEgresoEntity getTipoEgreso() {
		return tipoEgreso;
	}

	private void setTipoEgreso(TipoEgresoEntity tipoEgreso) {
		this.tipoEgreso = UtilObject.getDefault(tipoEgreso, TipoEgresoEntity.getDefaultObject());
		
	}
	
	

}
