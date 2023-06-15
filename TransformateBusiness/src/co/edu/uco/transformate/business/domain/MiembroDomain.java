package co.edu.uco.transformate.business.domain;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilDate;
import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class MiembroDomain {

	private MembresiaDomain membresiaDomain;
	private UUID identificador;
	private String nombre;
	private TipoDocumentoDomain tipoDocumentoDomain;
	private String identificacion;
	private LocalDate fechaNacimiento;
	private String correo;
	private String telefono;
	private PruebaFisicaDomain prueba;
	private ObjetivoEntrenamientoDomain objetivo;
	private TipoMiembroDomain tipoMiembroDomain;

	private static final MiembroDomain DEFAULT_OBJECT = new MiembroDomain();

	public static MiembroDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static MiembroDomain create(MembresiaDomain membresiaDomain, UUID identificador, String nombre,
			TipoDocumentoDomain tipoDocumentoDomain, String identificacion, LocalDate fechaNacimiento, String correo,
			String telefono, PruebaFisicaDomain prueba, ObjetivoEntrenamientoDomain objetivo,
			TipoMiembroDomain tipoMiembroDomain) {
		return new MiembroDomain(membresiaDomain, identificador, nombre, tipoDocumentoDomain, identificacion,
				fechaNacimiento, correo, telefono, prueba, objetivo, tipoMiembroDomain);
	}

	public MiembroDomain(MembresiaDomain membresiaDomain, UUID identificador, String nombre,
			TipoDocumentoDomain tipoDocumentoDomain, String identificacion, LocalDate fechaNacimiento, String correo,
			String telefono, PruebaFisicaDomain prueba, ObjetivoEntrenamientoDomain objetivo,
			TipoMiembroDomain tipoMiembroDomain) {
	
		setCorreo(correo);
		setFechaNacimiento(fechaNacimiento);
		setIdentificacion(identificacion);
		setIdentificador(identificador);
		setMembresiaDTO(membresiaDomain);
		setNombre(nombre);
		setObjetivo(objetivo);
		setPrueba(prueba);
		setTelefono(telefono);
		setTipoDocumentoDTO(tipoDocumentoDomain);
		setTipoMiembroDTO(tipoMiembroDomain);

	}

	private MiembroDomain() {
		
		setCorreo(UtilText.EMPTY);
		setFechaNacimiento(UtilDate.DEFAULT_DATE);
		setIdentificacion(UtilUUID.DEFAULT_UUID_AS_STRING);
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setMembresiaDTO(MembresiaDomain.getDefaultObject());
		setNombre(UtilText.getDefaultValue());
		setObjetivo(ObjetivoEntrenamientoDomain.getDefaultObject());
		setPrueba(PruebaFisicaDomain.getDefaultObject());
		setTelefono(UtilText.EMPTY);
		setTipoDocumentoDTO(TipoDocumentoDomain.getDefaultObject());
		setTipoMiembroDTO(TipoMiembroDomain.getDefaultObject());
	}



	public MembresiaDomain getMembresiaDTO() {
		return membresiaDomain;
	}

	private void setMembresiaDTO(MembresiaDomain membresiaDomain) {
		this.membresiaDomain =  UtilObject.getDefault(membresiaDomain, MembresiaDomain.getDefaultObject());
	
	}

	public UUID getIdentificador() {
		return identificador;
	}

	private void setIdentificador(UUID identificador) {
		this.identificador = identificador;
		
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
		
	}

	public TipoDocumentoDomain getTipoDocumentoDTO() {
		return tipoDocumentoDomain;
	}

	private void setTipoDocumentoDTO(TipoDocumentoDomain tipoDocumentoDomain) {
		this.tipoDocumentoDomain = UtilObject.getDefault(tipoDocumentoDomain, TipoDocumentoDomain.getDefaultObject());
		
	}

	public String getIdentificacion() {
		return identificacion;
	}

	private void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	private void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
		
	}

	public String getCorreo() {
		return correo;
	}

	private void setCorreo(String correo) {
		this.correo = correo;
	
	}

	public String getTelefono() {
		return telefono;
	}

	private void setTelefono(String telefono) {
		this.telefono = telefono;
		
	}

	public PruebaFisicaDomain getPrueba() {
		return prueba;
	}

	private void setPrueba(PruebaFisicaDomain prueba) {
		this.prueba = UtilObject.getDefault(prueba, PruebaFisicaDomain.getDefaultObject());
	
	}

	public ObjetivoEntrenamientoDomain getObjetivo() {
		return objetivo;
	}

	private void setObjetivo(ObjetivoEntrenamientoDomain objetivo) {
		this.objetivo = UtilObject.getDefault(objetivo, ObjetivoEntrenamientoDomain.getDefaultObject());
		
	}

	public TipoMiembroDomain getTipoMiembroDTO() {
		return tipoMiembroDomain;
	}

	private void setTipoMiembroDTO(TipoMiembroDomain tipoMiembroDomain) {
		this.tipoMiembroDomain = (TipoMiembroDomain) UtilObject.getDefault(tipoMiembroDomain,TipoDocumentoDomain.getDefaultObject());
		
	}

}
