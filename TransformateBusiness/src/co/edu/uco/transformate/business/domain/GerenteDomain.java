package co.edu.uco.transformate.business.domain;


import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilNumber;
import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class GerenteDomain {
	
	private UUID identificador;
	private TipoDocumentoDomain tipoDocumentoDomain;
	private String identificacion;
	private String nombre;
	private String usuario;
	private String constraseña;
	private String telefono;
	private int salario;
	private GimnasioDomain gimnasioDomain;
	
	private static final GerenteDomain DEFAULT_OBJECT = new GerenteDomain();

	public static GerenteDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static GerenteDomain create(final UUID identificador, final TipoDocumentoDomain tipoDocumentoDomain,
			final String identificacion, final String nombre, final String usuario, final String constraseña,
			final String telefono, final int salario, final GimnasioDomain gimnasioDomain) {
		return new GerenteDomain(identificador,tipoDocumentoDomain,identificacion,nombre,usuario,constraseña,telefono,salario,gimnasioDomain);
	}

	public  GerenteDomain(final UUID identificador, final TipoDocumentoDomain tipoDocumentoDomain, final String identificacion,
			final String nombre, final String usuario, final String constraseña, final String telefono,
			final int salario, final GimnasioDomain gimnasioDomain) {
	
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

	private GerenteDomain() {
	
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setTipoDocumentoDTO(TipoDocumentoDomain.getDefaultObject());
		setNombre(UtilText.getDefaultValue());
		setIdentificacion(UtilText.EMPTY);
		setUsuario(UtilText.EMPTY);
		setConstraseña(UtilText.EMPTY);
		setTelefono(UtilText.EMPTY);
		setGimnasioDTO(GimnasioDomain.getDefaultObject());

	}



	public final UUID getIdentificador() {
		return identificador;
	}

	private final void setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
	
	}

	public final TipoDocumentoDomain getTipoDocumentoDTO() {
		return tipoDocumentoDomain;
	}

	private final void setTipoDocumentoDTO(TipoDocumentoDomain tipoDocumentoDomain) {
		this.tipoDocumentoDomain = UtilObject.getDefault(tipoDocumentoDomain, TipoDocumentoDomain.getDefaultObject());
	
	}

	public final String getIdentificacion() {
		return identificacion;
	}

	private final void setIdentificacion(String identificacion) {
		this.identificacion = UtilText.getUtilText().applyTrim(identificacion);
	
	}

	public final String getNombre() {
		return nombre;
	}

	private final void setNombre(String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);

	}

	public final String getUsuario() {
		return usuario;
	}

	private final void setUsuario(String usuario) {
		this.usuario = UtilText.getUtilText().applyTrim(usuario);
	
	}

	public final String getConstraseña() {
		return constraseña;
	}

	private final void setConstraseña(String constraseña) {
		this.constraseña = UtilText.getUtilText().applyTrim(constraseña);
	
	}

	public final String getTelefono() {
		return telefono;
	}

	private final void setTelefono(String telefono) {
		this.telefono = UtilText.getUtilText().applyTrim(telefono);
	
	}

	public final int getSalario() {
		return salario;
	}

	private final void setSalario(int salario) {
		this.salario = UtilNumber.getDefaultNumber(salario);
	
	}

	public final GimnasioDomain getGimnasioDTO() {
		return gimnasioDomain;
	}

	private final void setGimnasioDTO(GimnasioDomain gimnasioDomain) {
		this.gimnasioDomain = UtilObject.getDefault(gimnasioDomain, GimnasioDomain.getDefaultObject());
	
	}

}
