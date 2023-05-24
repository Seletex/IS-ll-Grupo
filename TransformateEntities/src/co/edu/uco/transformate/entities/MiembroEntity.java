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
	public MiembroEntity(MembresiaEntity membresiaEntity, UUID identificador, String nombre, TipoDocumentoEntity tipoDocumentoEntity,
			String identificacion, LocalDate fechaNacimiento, String correo, String telefono, PruebaFisicaEntity prueba,
			ObjetivoEntrenamientoEntity objetivo, TipoMiembroEntity tipoMiembroEntity) {
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
	public MiembroEntity() {
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
	public MiembroEntity setMembresiaDTO(MembresiaEntity membresiaEntity) {
		this.membresiaEntity = (MembresiaEntity) UtilObject.getDefault(membresiaEntity, MembresiaEntity.create());return this;
	}
	public UUID getIdentificador() {
		return identificador;
	}
	public MiembroEntity setIdentificador(UUID identificador) {
		this.identificador = identificador;return this;
	}
	public String getNombre() {
		return nombre;
	}
	public MiembroEntity setNombre(String nombre) {
		this.nombre = nombre;return this;
	}
	public TipoDocumentoEntity getTipoDocumentoDTO() {
		return tipoDocumentoEntity;
	}
	public MiembroEntity setTipoDocumentoDTO(TipoDocumentoEntity tipoDocumentoEntity) {
		this.tipoDocumentoEntity = UtilObject.getDefault(null, null);return this;
	}
	public String getIdentificacion() {
		return identificacion;
	}
	public MiembroEntity setIdentificacion(String identificacion) {
		this.identificacion = identificacion;return this;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public MiembroEntity setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;return this;
	}
	public String getCorreo() {
		return correo;
	}
	public MiembroEntity setCorreo(String correo) {
		this.correo = correo;return this;
	}
	public String getTelefono() {
		return telefono;
	}
	public MiembroEntity setTelefono(String telefono) {
		this.telefono = telefono;return this;
	}
	public PruebaFisicaEntity getPrueba() {
		return prueba;
	}
	public MiembroEntity setPrueba(PruebaFisicaEntity prueba) {
		this.prueba = UtilObject.getDefault(null, null);return this;
	}
	public ObjetivoEntrenamientoEntity getObjetivo() {
		return objetivo;
	}
	public MiembroEntity setObjetivo(ObjetivoEntrenamientoEntity objetivo) {
		this.objetivo = UtilObject.getDefault(null, null);return this;
	}
	public TipoMiembroEntity getTipoMiembroDTO() {
		return tipoMiembroEntity;
	}
	public MiembroEntity setTipoMiembroDTO(TipoMiembroEntity tipoMiembroEntity) {
		this.tipoMiembroEntity = UtilObject.getDefault(null, null);return this;
	}

}
