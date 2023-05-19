package co.edu.uco.transformate.dto;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilObject;

public class MiembroDTO {

	private MembresiaDTO membresiaDTO;
	private UUID identificador;
	private String nombre;
	private TipoDocumentoDTO tipoDocumentoDTO;
	private String identificacion;
	private LocalDate fechaNacimiento;
	private String correo;
	private String telefono;
	private PruebaFisicaDTO prueba;
	private ObjetivoEntrenamientoDTO objetivo;
	private TipoMiembroDTO tipoMiembroDTO;
	public MiembroDTO(MembresiaDTO membresiaDTO, UUID identificador, String nombre, TipoDocumentoDTO tipoDocumentoDTO,
			String identificacion, LocalDate fechaNacimiento, String correo, String telefono, PruebaFisicaDTO prueba,
			ObjetivoEntrenamientoDTO objetivo, TipoMiembroDTO tipoMiembroDTO) {
		super();
		setCorreo(correo);
		setFechaNacimiento(fechaNacimiento);
		setIdentificacion(identificacion);
		setIdentificador(identificador);
		setMembresiaDTO(membresiaDTO);
		setNombre(nombre);
		setObjetivo(objetivo);
		setPrueba(prueba);
		setTelefono(telefono);
		setTipoDocumentoDTO(tipoDocumentoDTO);
		setTipoMiembroDTO(tipoMiembroDTO);
		
	}
	public MiembroDTO() {
		super();
		setCorreo(correo);
		setFechaNacimiento(fechaNacimiento);
		setIdentificacion(identificacion);
		setIdentificador(identificador);
		setMembresiaDTO(membresiaDTO);
		setNombre(nombre);
		setObjetivo(objetivo);
		setPrueba(prueba);
		setTelefono(telefono);
		setTipoDocumentoDTO(tipoDocumentoDTO);
		setTipoMiembroDTO(tipoMiembroDTO);
	}
	
	public static MiembroDTO create() {
		return new MiembroDTO();
	}
	public MembresiaDTO getMembresiaDTO() {
		return membresiaDTO;
	}
	public MiembroDTO setMembresiaDTO(MembresiaDTO membresiaDTO) {
		this.membresiaDTO = (MembresiaDTO) UtilObject.getDefault(membresiaDTO, MembresiaDTO.create());return this;
	}
	public UUID getIdentificador() {
		return identificador;
	}
	public MiembroDTO setIdentificador(UUID identificador) {
		this.identificador = identificador;return this;
	}
	public String getNombre() {
		return nombre;
	}
	public MiembroDTO setNombre(String nombre) {
		this.nombre = nombre;return this;
	}
	public TipoDocumentoDTO getTipoDocumentoDTO() {
		return tipoDocumentoDTO;
	}
	public MiembroDTO setTipoDocumentoDTO(TipoDocumentoDTO tipoDocumentoDTO) {
		this.tipoDocumentoDTO = UtilObject.getDefault(null, null);return this;
	}
	public String getIdentificacion() {
		return identificacion;
	}
	public MiembroDTO setIdentificacion(String identificacion) {
		this.identificacion = identificacion;return this;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public MiembroDTO setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;return this;
	}
	public String getCorreo() {
		return correo;
	}
	public MiembroDTO setCorreo(String correo) {
		this.correo = correo;return this;
	}
	public String getTelefono() {
		return telefono;
	}
	public MiembroDTO setTelefono(String telefono) {
		this.telefono = telefono;return this;
	}
	public PruebaFisicaDTO getPrueba() {
		return prueba;
	}
	public MiembroDTO setPrueba(PruebaFisicaDTO prueba) {
		this.prueba = UtilObject.getDefault(null, null);return this;
	}
	public ObjetivoEntrenamientoDTO getObjetivo() {
		return objetivo;
	}
	public MiembroDTO setObjetivo(ObjetivoEntrenamientoDTO objetivo) {
		this.objetivo = UtilObject.getDefault(null, null);return this;
	}
	public TipoMiembroDTO getTipoMiembroDTO() {
		return tipoMiembroDTO;
	}
	public MiembroDTO setTipoMiembroDTO(TipoMiembroDTO tipoMiembroDTO) {
		this.tipoMiembroDTO = UtilObject.getDefault(null, null);return this;
	}

}
