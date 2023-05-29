package co.edu.uco.transformate.business.domain;

import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilNumber;
import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class RecepcionistaDomain {
	
	private UUID identificador;
	private TipoDocumentoDomain tipoDocumentoDomain;
	private String identificacion;
	private String nombre;
	private String usuario;
	private String constraseña;
	private String telefono;
	private int salario;
	private GimnasioDomain gimnasioDomain;
	
	private static final RecepcionistaDomain DEFAULT_OBJECT = new RecepcionistaDomain();

	public static RecepcionistaDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static RecepcionistaDomain create(final UUID identificador, final TipoDocumentoDomain tipoDocumentoDomain,
			final String identificacion, final String nombre, final String usuario, final String constraseña,
			final String telefono, final int salario, final GimnasioDomain gimnasioDomain) {
		return new RecepcionistaDomain(identificador,tipoDocumentoDomain,identificacion,nombre,usuario,constraseña,telefono,salario,gimnasioDomain);
	}

	public RecepcionistaDomain(final UUID identificador, final TipoDocumentoDomain tipoDocumentoDomain, final String identificacion,
			final String nombre, final String usuario, final String constraseña, final String telefono,
			final int salario, final GimnasioDomain gimnasioDomain) {
		super();
		setIdentificador(identificador);
		setTipoDocumentoDTO(tipoDocumentoDomain);
		setIdentificacion(identificacion);
		setNombre(nombre);
		setUsuario(usuario);
		setConstraseña(constraseña);
		setTelefono(telefono);
		setSalario(salario);
		setGimnasioDTO(gimnasioDomain);

	}

	public RecepcionistaDomain() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setTipoDocumentoDTO(TipoDocumentoDomain.getDefaultObject());
		setNombre(UtilText.getDefaultValue());
		setIdentificacion(UtilText.EMPTY);
		setUsuario(UtilText.EMPTY);
		setConstraseña(UtilText.EMPTY);
		setTelefono(UtilText.EMPTY);
		setGimnasioDTO(GimnasioDomain.getDefaultObject());

	}

	public static RecepcionistaDomain create() {
		return new RecepcionistaDomain();
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	public final RecepcionistaDomain setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		;
		return this;
	}

	public final TipoDocumentoDomain getTipoDocumentoDTO() {
		return tipoDocumentoDomain;
	}

	public final RecepcionistaDomain setTipoDocumentoDTO(TipoDocumentoDomain tipoDocumentoDomain) {
		this.tipoDocumentoDomain = UtilObject.getDefault(tipoDocumentoDomain, TipoDocumentoDomain.getDefaultObject());
		return this;
	}

	public final String getIdentificacion() {
		return identificacion;
	}

	public final RecepcionistaDomain setIdentificacion(String identificacion) {
		this.identificacion = UtilText.getUtilText().applyTrim(identificacion);
		return this;
	}

	public final String getNombre() {
		return nombre;
	}

	public final RecepcionistaDomain setNombre(String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
		return this;
	}

	public final String getUsuario() {
		return usuario;
	}

	public final RecepcionistaDomain setUsuario(String usuario) {
		this.usuario = UtilText.getUtilText().applyTrim(usuario);
		return this;
	}

	public final String getConstraseña() {
		return constraseña;
	}

	public final RecepcionistaDomain setConstraseña(String constraseña) {
		this.constraseña = UtilText.getUtilText().applyTrim(constraseña);
		return this;
	}

	public final String getTelefono() {
		return telefono;
	}

	public final RecepcionistaDomain setTelefono(String telefono) {
		this.telefono = UtilText.getUtilText().applyTrim(telefono);
		return this;
	}

	public final int getSalario() {
		return salario;
	}

	public final RecepcionistaDomain setSalario(int salario) {
		this.salario = UtilNumber.getDefaultNumber();
		return this;
	}

	public final GimnasioDomain getGimnasioDTO() {
		return gimnasioDomain;
	}

	public final RecepcionistaDomain setGimnasioDTO(GimnasioDomain gimnasioDomain) {
		this.gimnasioDomain = UtilObject.getDefault(gimnasioDomain, GimnasioDomain.getDefaultObject());
		return this;
	}


}
