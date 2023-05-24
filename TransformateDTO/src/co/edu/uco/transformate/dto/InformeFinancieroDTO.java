package co.edu.uco.transformate.dto;

import java.time.LocalDate;
import java.util.UUID;

import javax.print.attribute.standard.PrinterMoreInfoManufacturer;

import co.edu.uco.transformate.crosscutting.utils.UtilDate;
import co.edu.uco.transformate.crosscutting.utils.UtilNumber;
import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class InformeFinancieroDTO {
	private UUID identificador;
	private LocalDate fechaInicioDate;
	private LocalDate fechaFinDate;
	private EgresoDTO egreso;
	private float beneficio;
	private float perdida;
	public InformeFinancieroDTO(UUID identificador, LocalDate fechaInicioDate, LocalDate fechaFinDate, EgresoDTO egreso,
			float beneficio, float perdida) {
		super();
		setBeneficio(beneficio);
		setEgreso(egreso);
		setFechaFinDate(fechaFinDate);
		setFechaInicioDate(fechaInicioDate);
		setIdentificador(identificador);
		setPerdida(perdida);
		
	}
	public InformeFinancieroDTO() {
		super();
		setBeneficio(UtilNumber.ZERO);
		setEgreso(EgresoDTO.create());
		setFechaFinDate(UtilDate.DEFAULT_DATE);
		setFechaInicioDate(UtilDate.DEFAULT_DATE);
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setPerdida(UtilNumber.ZERO);
	}
	
	public static InformeFinancieroDTO create() {
		return new InformeFinancieroDTO();
	}
	public UUID getIdentificador() {
		return identificador;
	}
	public InformeFinancieroDTO setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);return this;
	}
	public LocalDate getFechaInicioDate() {
		return fechaInicioDate;
	}
	public InformeFinancieroDTO setFechaInicioDate(LocalDate fechaInicioDate) {
		this.fechaInicioDate = UtilDate.getDefault(fechaInicioDate);;return this;
	}
	public LocalDate getFechaFinDate() {
		return fechaFinDate;
	}
	public InformeFinancieroDTO setFechaFinDate(LocalDate fechaFinDate) {
		this.fechaFinDate =  UtilDate.getDefault(fechaFinDate);return this;
	}
	public EgresoDTO getEgreso() {
		return egreso;
	}
	public InformeFinancieroDTO setEgreso(EgresoDTO egreso) {
		this.egreso = UtilObject.getDefault(egreso,EgresoDTO.create());return this;
	}
	public float getBeneficio() {
		return beneficio;
	}
	public InformeFinancieroDTO setBeneficio(float beneficio) {
		this.beneficio = (float) UtilNumber.getDefaultNumber(beneficio);return this;
	}
	public float getPerdida() {
		return perdida;
	}
	public InformeFinancieroDTO setPerdida(float perdida) {
		this.perdida = (float) UtilNumber.getDefaultNumber(perdida);return this;
	}

	
}
