package co.edu.uco.transformate.entities;

import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilNumber;
import co.edu.uco.transformate.crosscutting.utils.UtilObject;

import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class EntrenadorEntity {

	private UUID identificador;
	private TipoDocumentoEntity tipoDocumentoEntity;
	private String identificacion;
	private String nombre;
	private String usuario;
	private String constraseña;
	private String telefono;
	private int salario;
	private GimnasioEntity gimnasioEntity;

	private static final EntrenadorEntity DEFAULT_OBJECT = new EntrenadorEntity();

	public static EntrenadorEntity getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static EntrenadorEntity create(final UUID identificador, final TipoDocumentoEntity tipoDocumentoEntity,
			final String identificacion, final String nombre, final String usuario, final String constraseña,
			final String telefono, final int salario, final GimnasioEntity gimnasioEntity) {
		return new EntrenadorEntity(identificador,tipoDocumentoEntity,identificacion,nombre,usuario,constraseña,telefono,salario,gimnasioEntity);
	}

	public  EntrenadorEntity(final UUID identificador, final TipoDocumentoEntity tipoDocumentoEntity,
			final String identificacion, final String nombre, final String usuario, final String constraseña,
			final String telefono, final int salario, final GimnasioEntity gimnasioEntity) {
	
		setIdentificador(identificador);
		setTipoDocumentoDTO(tipoDocumentoEntity);
		setIdentificacion(identificacion);
		setNombre(nombre);
		setUsuario(usuario);
		setConstraseña(constraseña);
		setTelefono(telefono);
		setSalario(salario);
		setGimnasioDTO(gimnasioEntity);

	}

	private EntrenadorEntity() {
		
		setIdentificador(UtilUUID.genereteNewUUID());
		setTipoDocumentoDTO(TipoDocumentoEntity.getDefaultObject());
		setNombre(UtilText.getDefaultValue());
		setIdentificacion(UtilText.EMPTY);
		setUsuario(UtilText.EMPTY);
		setConstraseña(UtilText.EMPTY);
		setTelefono(UtilText.EMPTY);
		setGimnasioDTO(GimnasioEntity.getDefaultObject());

	}

	public static EntrenadorEntity create() {
		return new EntrenadorEntity();
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	private final void setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
	
	
	}

	public final TipoDocumentoEntity getTipoDocumentoDTO() {
		return tipoDocumentoEntity;
	}

	private final void setTipoDocumentoDTO(TipoDocumentoEntity tipoDocumentoEntity) {
		this.tipoDocumentoEntity = UtilObject.getDefault(tipoDocumentoEntity, TipoDocumentoEntity.getDefaultObject());

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

	public final GimnasioEntity getGimnasioDTO() {
		return gimnasioEntity;
	}

	private final void setGimnasioDTO(GimnasioEntity gimnasioEntity) {
		this.gimnasioEntity = UtilObject.getDefault(gimnasioEntity, GimnasioEntity.getDefaultObject());

	}

}
