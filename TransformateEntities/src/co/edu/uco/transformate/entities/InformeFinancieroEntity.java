package co.edu.uco.transformate.entities;

import java.time.LocalDate;
import java.util.UUID;

import javax.print.attribute.standard.PrinterMoreInfoManufacturer;

import co.edu.uco.transformate.crosscutting.utils.UtilDate;
import co.edu.uco.transformate.crosscutting.utils.UtilNumber;
import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class InformeFinancieroEntity {
	private UUID identificador;
	private LocalDate fechaInicioDate;
	private LocalDate fechaFinDate;
	private EgresoEntity egreso;
	private float beneficio;
	private float perdida;
	public InformeFinancieroEntity(UUID identificador, LocalDate fechaInicioDate, LocalDate fechaFinDate, EgresoEntity egreso,
			float beneficio, float perdida) {
		super();
		setBeneficio(beneficio);
		setEgreso(egreso);
		setFechaFinDate(fechaFinDate);
		setFechaInicioDate(fechaInicioDate);
		setIdentificador(identificador);
		setPerdida(perdida);
		
	}
	public InformeFinancieroEntity() {
		super();
		setBeneficio(UtilNumber.ZERO);
		setEgreso(EgresoEntity.create());
		setFechaFinDate(UtilDate.DEFAULT_DATE);
		setFechaInicioDate(UtilDate.DEFAULT_DATE);
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setPerdida(UtilNumber.ZERO);
	}
	
	public static InformeFinancieroEntity create() {
		return new InformeFinancieroEntity();
	}
	public UUID getIdentificador() {
		return identificador;
	}
	public InformeFinancieroEntity setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);return this;
	}
	public LocalDate getFechaInicioDate() {
		return fechaInicioDate;
	}
	public InformeFinancieroEntity setFechaInicioDate(LocalDate fechaInicioDate) {
		this.fechaInicioDate = UtilDate.getDefault(fechaInicioDate);;return this;
	}
	public LocalDate getFechaFinDate() {
		return fechaFinDate;
	}
	public InformeFinancieroEntity setFechaFinDate(LocalDate fechaFinDate) {
		this.fechaFinDate =  UtilDate.getDefault(fechaFinDate);return this;
	}
	public EgresoEntity getEgreso() {
		return egreso;
	}
	public InformeFinancieroEntity setEgreso(EgresoEntity egreso) {
		this.egreso = UtilObject.getDefault(egreso,EgresoEntity.create());return this;
	}
	public float getBeneficio() {
		return beneficio;
	}
	public InformeFinancieroEntity setBeneficio(float beneficio) {
		this.beneficio = (float) UtilNumber.getDefaultNumber(beneficio);return this;
	}
	public float getPerdida() {
		return perdida;
	}
	public InformeFinancieroEntity setPerdida(float perdida) {
		this.perdida = (float) UtilNumber.getDefaultNumber(perdida);return this;
	}

	
}
