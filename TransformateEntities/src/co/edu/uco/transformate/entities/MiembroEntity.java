package co.edu.uco.transformate.entities;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilObject;

public class MiembroEntity {

	private MembresiaEntity membresiaEntity;
	private UUID identificador;
	private String nombre;
	private TipoDocumentoEntity tipoDocumentoEntity;
	private String identificacion;
	private LocalDate fechaNacimiento;
	private String correo;
	private String telefono;
	private PruebaFisicaEntity prueba;
	private ObjetivoEntrenamientoEntity objetivo;
	private TipoMiembroEntity tipoMiembroEntity;

	private static final MiembroEntity DEFAULT_OBJECT = new MiembroEntity();

	public static MiembroEntity getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static MiembroEntity create(MembresiaEntity membresiaEntity, UUID identificador, String nombre,
			TipoDocumentoEntity tipoDocumentoEntity, String identificacion, LocalDate fechaNacimiento, String correo,
			String telefono, PruebaFisicaEntity prueba, ObjetivoEntrenamientoEntity objetivo,
			TipoMiembroEntity tipoMiembroEntity) {
		return new MiembroEntity(membresiaEntity, identificador, nombre, tipoDocumentoEntity, identificacion,
				fechaNacimiento, correo, telefono, prueba, objetivo, tipoMiembroEntity);
	}

	private MiembroEntity(MembresiaEntity membresiaEntity, UUID identificador, String nombre,
			TipoDocumentoEntity tipoDocumentoEntity, String identificacion, LocalDate fechaNacimiento, String correo,
			String telefono, PruebaFisicaEntity prueba, ObjetivoEntrenamientoEntity objetivo,
			TipoMiembroEntity tipoMiembroEntity) {
		super();
		setCorreo(correo);
		setFechaNacimiento(fechaNacimiento);
		setIdentificacion(identificacion);
		setIdentificador(identificador);
		setMembresiaDTO(membresiaEntity);
		setNombre(nombre);
		setObjetivo(objetivo);
		setPrueba(prueba);
		setTelefono(telefono);
		setTipoDocumentoDTO(tipoDocumentoEntity);
		setTipoMiembroDTO(tipoMiembroEntity);

	}

	private MiembroEntity() {
		super();
		setCorreo(correo);
		setFechaNacimiento(fechaNacimiento);
		setIdentificacion(identificacion);
		setIdentificador(identificador);
		setMembresiaDTO(membresiaEntity);
		setNombre(nombre);
		setObjetivo(objetivo);
		setPrueba(prueba);
		setTelefono(telefono);
		setTipoDocumentoDTO(tipoDocumentoEntity);
		setTipoMiembroDTO(tipoMiembroEntity);
	}

	public static MiembroEntity create() {
		return new MiembroEntity();
	}

	public MembresiaEntity getMembresiaDTO() {
		return membresiaEntity;
	}

	private void setMembresiaDTO(MembresiaEntity membresiaEntity) {
		this.membresiaEntity = (MembresiaEntity) UtilObject.getDefault(membresiaEntity, MembresiaEntity.create());
	
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

	public TipoDocumentoEntity getTipoDocumentoDTO() {
		return tipoDocumentoEntity;
	}

	private void setTipoDocumentoDTO(TipoDocumentoEntity tipoDocumentoEntity) {
		this.tipoDocumentoEntity = UtilObject.getDefault(null, null);
		
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

	public PruebaFisicaEntity getPrueba() {
		return prueba;
	}

	private void setPrueba(PruebaFisicaEntity prueba) {
		this.prueba = UtilObject.getDefault(null, null);
	
	}

	public ObjetivoEntrenamientoEntity getObjetivo() {
		return objetivo;
	}

	private void setObjetivo(ObjetivoEntrenamientoEntity objetivo) {
		this.objetivo = UtilObject.getDefault(null, null);
		
	}

	public TipoMiembroEntity getTipoMiembroDTO() {
		return tipoMiembroEntity;
	}

	private void setTipoMiembroDTO(TipoMiembroEntity tipoMiembroEntity) {
		this.tipoMiembroEntity = UtilObject.getDefault(null, null);
		
	}

}
