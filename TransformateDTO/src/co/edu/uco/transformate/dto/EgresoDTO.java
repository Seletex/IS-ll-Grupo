package co.edu.uco.transformate.dto;


import java.time.LocalDateTime;
import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilDate;
import co.edu.uco.transformate.crosscutting.utils.UtilNumber;
import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class EgresoDTO {
	
	private UUID identiUuid;
	private String nombre;
	private String descripcion;
	private int total;
	private LocalDateTime fecha;
	private GerenteDTO responsable;
	private TipoEgresoDTO tipoEgreso;
	
	public EgresoDTO(UUID identiUuid, String nombre, String descripcion, int total, LocalDateTime fecha,
			GerenteDTO responsable, TipoEgresoDTO tipoEgreso) {
		setIdentiUuid(identiUuid);
		setDescripcion(descripcion);
		setNombre(nombre);
		setTipoEgreso(tipoEgreso);
		setTotal(total);
		setFecha(fecha);
		setResponsable(responsable);
		
	}

	public EgresoDTO() {
		setIdentiUuid(UtilUUID.DEFAULT_UUID);
		setNombre(UtilText.getDefaultValue());
		setTipoEgreso(TipoEgresoDTO.create());
		setDescripcion(UtilText.EMPTY);
		setTotal(UtilNumber.ZERO);
		setFecha(UtilDate.DEFAULT_DATE_TIME);
		setResponsable(GerenteDTO.create());
	}
	
	public static EgresoDTO create() {
		return new EgresoDTO();
	}

	public UUID getIdentiUuid() {
		return identiUuid;
	}

	public EgresoDTO setIdentiUuid(UUID identiUuid) {
		this.identiUuid = UtilUUID.getDefault(identiUuid);return this;
	}

	public String getNombre() {
		return nombre;
	}

	public EgresoDTO setNombre(String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);return this;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public EgresoDTO setDescripcion(String descripcion) {
		this.descripcion = UtilText.getUtilText().applyTrim(descripcion);return this;
	}

	public int getTotal() {
		return total;
	}

	public EgresoDTO setTotal(int total) {
		this.total = UtilNumber.getDefaultNumber(total);return this;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public EgresoDTO setFecha(LocalDateTime fecha) {
		this.fecha = UtilDate.getDefaultTime(fecha);return this;
	}

	public GerenteDTO getResponsable() {
		return responsable;
	}

	public EgresoDTO setResponsable(GerenteDTO responsable) {
		this.responsable = UtilObject.getDefault(responsable, GerenteDTO.create());return this;
	}

	public TipoEgresoDTO getTipoEgreso() {
		return tipoEgreso;
	}

	public EgresoDTO setTipoEgreso(TipoEgresoDTO tipoEgreso) {
		this.tipoEgreso = UtilObject.getDefault(tipoEgreso, TipoEgresoDTO.create());
		return this;
	}
	
	

}
