package co.edu.uco.transformate.entities;

import java.time.LocalDate;
import java.util.UUID;



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

	private static final InformeFinancieroEntity DEFAULT_OBJECT = new InformeFinancieroEntity();

	public static InformeFinancieroEntity getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static InformeFinancieroEntity create(UUID identificador, LocalDate fechaInicioDate, LocalDate fechaFinDate,
			EgresoEntity egreso, float beneficio, float perdida) {
		return new InformeFinancieroEntity(identificador, fechaInicioDate, fechaFinDate, egreso, perdida, beneficio);
	}

	private InformeFinancieroEntity(UUID identificador, LocalDate fechaInicioDate, LocalDate fechaFinDate,
			EgresoEntity egreso, float beneficio, float perdida) {
		super();
		setBeneficio(beneficio);
		setEgreso(egreso);
		setFechaFinDate(fechaFinDate);
		setFechaInicioDate(fechaInicioDate);
		setIdentificador(identificador);
		setPerdida(perdida);

	}

	private InformeFinancieroEntity() {
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

	private void setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
	
	}

	public LocalDate getFechaInicioDate() {
		return fechaInicioDate;
	}

	private void setFechaInicioDate(LocalDate fechaInicioDate) {
		this.fechaInicioDate = UtilDate.getDefault(fechaInicioDate);
		
		
	}

	public LocalDate getFechaFinDate() {
		return fechaFinDate;
	}

	public InformeFinancieroEntity setFechaFinDate(LocalDate fechaFinDate) {
		this.fechaFinDate = UtilDate.getDefault(fechaFinDate);
		return this;
	}

	public EgresoEntity getEgreso() {
		return egreso;
	}

	public InformeFinancieroEntity setEgreso(EgresoEntity egreso) {
		this.egreso = UtilObject.getDefault(egreso, EgresoEntity.create());
		return this;
	}

	public float getBeneficio() {
		return beneficio;
	}

	public InformeFinancieroEntity setBeneficio(float beneficio) {
		this.beneficio = (float) UtilNumber.getDefaultNumber(beneficio);
		return this;
	}

	public float getPerdida() {
		return perdida;
	}

	public InformeFinancieroEntity setPerdida(float perdida) {
		this.perdida = (float) UtilNumber.getDefaultNumber(perdida);
		return this;
	}

}
