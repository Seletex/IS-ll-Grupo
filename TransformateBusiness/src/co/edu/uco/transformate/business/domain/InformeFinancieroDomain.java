package co.edu.uco.transformate.business.domain;

import java.time.LocalDate;
import java.util.UUID;



import co.edu.uco.transformate.crosscutting.utils.UtilDate;
import co.edu.uco.transformate.crosscutting.utils.UtilNumber;
import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class InformeFinancieroDomain {
	private UUID identificador;
	private LocalDate fechaInicioDate;
	private LocalDate fechaFinDate;
	private EgresoDomain egreso;
	private float beneficio;
	private float perdida;

	

	public static InformeFinancieroDomain create(UUID identificador, LocalDate fechaInicioDate, LocalDate fechaFinDate,
			EgresoDomain egreso, float beneficio, float perdida) {
		return new InformeFinancieroDomain(identificador, fechaInicioDate, fechaFinDate, egreso, perdida, beneficio);
	}

	public  InformeFinancieroDomain(UUID identificador, LocalDate fechaInicioDate, LocalDate fechaFinDate,
			EgresoDomain egreso, float beneficio, float perdida) {
	
		setBeneficio(beneficio);
		setEgreso(egreso);
		setFechaFinDate(fechaFinDate);
		setFechaInicioDate(fechaInicioDate);
		setIdentificador(identificador);
		setPerdida(perdida);

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

	public InformeFinancieroDomain setFechaFinDate(LocalDate fechaFinDate) {
		this.fechaFinDate = UtilDate.getDefault(fechaFinDate);
		return this;
	}

	public EgresoDomain getEgreso() {
		return egreso;
	}

	public InformeFinancieroDomain setEgreso(EgresoDomain egreso) {
		this.egreso = UtilObject.getDefault(egreso, EgresoDomain.getDefaultObject());
		return this;
	}

	public float getBeneficio() {
		return beneficio;
	}

	public InformeFinancieroDomain setBeneficio(float beneficio) {
		this.beneficio = (float) UtilNumber.getDefaultNumber(beneficio);
		return this;
	}

	public float getPerdida() {
		return perdida;
	}

	public InformeFinancieroDomain setPerdida(float perdida) {
		this.perdida = (float) UtilNumber.getDefaultNumber(perdida);
		return this;
	}

}
