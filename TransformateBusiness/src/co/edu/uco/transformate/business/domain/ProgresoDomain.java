package co.edu.uco.transformate.business.domain;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilDate;
import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class ProgresoDomain {
	




	private LocalDate fecha;
	private UUID identificador;
	private MiembroDomain miembroDomain;
	private String descripcion;
	

	private static final ProgresoDomain DEFAULT_OBJECT = new ProgresoDomain();

	public static ProgresoDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static ProgresoDomain create(UUID identificador, String nombre,MiembroDomain miembroDomain,LocalDate fecha
			) {
		return new ProgresoDomain(identificador,nombre,miembroDomain,fecha);
	}
	
	public ProgresoDomain(UUID identificador, String nombre,MiembroDomain miembroDomain,LocalDate fecha) {
	
		setIdentificador(identificador);
		setDescripcion(nombre);
		setMiembroDTO(miembroDomain);
setFecha(fecha);
	}

	private ProgresoDomain() {

		setIdentificador(UtilUUID.DEFAULT_UUID);
		setMiembroDTO(MiembroDomain.getDefaultObject());
		setDescripcion(UtilText.getDefaultValue());
		setFecha(UtilDate.DEFAULT_DATE);
	}

	public static ProgresoDomain create() {
		return new ProgresoDomain();
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

	public MiembroDomain getMiembroDTO() {
		return miembroDomain;
	}

	private void setMiembroDTO(MiembroDomain miembroDomain) {
		this.miembroDomain = UtilObject.getDefault(miembroDomain,MiembroDomain.getDefaultObject());
	}

	public LocalDate getFecha() {
		return fecha;
	}

	private void setFecha(LocalDate fecha) {
		this.fecha = UtilDate.getDefault(fecha);
	}

}
