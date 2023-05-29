package co.edu.uco.transformate.entities;

import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilNumber;
import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class RecepcionistaEntity {
	
	private UUID identificador;
	private TipoDocumentoEntity tipoDocumentoEntity;
	private String identificacion;
	private String nombre;
	private String usuario;
	private String constraseña;
	private String telefono;
	private int salario;
	private GimnasioEntity gimnasioEntity;
	
	private static final RecepcionistaEntity DEFAULT_OBJECT = new RecepcionistaEntity();

	public static RecepcionistaEntity getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static RecepcionistaEntity create(final UUID identificador, final TipoDocumentoEntity tipoDocumentoEntity,
			final String identificacion, final String nombre, final String usuario, final String constraseña,
			final String telefono, final int salario, final GimnasioEntity gimnasioEntity) {
		return new RecepcionistaEntity(identificador,tipoDocumentoEntity,identificacion,nombre,usuario,constraseña,telefono,salario,gimnasioEntity);
	}

	public RecepcionistaEntity(final UUID identificador, final TipoDocumentoEntity tipoDocumentoEntity, final String identificacion,
			final String nombre, final String usuario, final String constraseña, final String telefono,
			final int salario, final GimnasioEntity gimnasioEntity) {
		
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

	public RecepcionistaEntity() {
		
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setTipoDocumentoDTO(TipoDocumentoEntity.getDefaultObject());
		setNombre(UtilText.getDefaultValue());
		setIdentificacion(UtilText.EMPTY);
		setUsuario(UtilText.EMPTY);
		setConstraseña(UtilText.EMPTY);
		setTelefono(UtilText.EMPTY);
		setGimnasioDTO(GimnasioEntity.getDefaultObject());

	}

	public static RecepcionistaEntity create() {
		return new RecepcionistaEntity();
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	public final RecepcionistaEntity setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		
		return this;
	}

	public final TipoDocumentoEntity getTipoDocumentoDTO() {
		return tipoDocumentoEntity;
	}

	public final RecepcionistaEntity setTipoDocumentoDTO(TipoDocumentoEntity tipoDocumentoEntity) {
		this.tipoDocumentoEntity = UtilObject.getDefault(tipoDocumentoEntity, TipoDocumentoEntity.getDefaultObject());
		return this;
	}

	public final String getIdentificacion() {
		return identificacion;
	}

	public final RecepcionistaEntity setIdentificacion(String identificacion) {
		this.identificacion = UtilText.getUtilText().applyTrim(identificacion);
		return this;
	}

	public final String getNombre() {
		return nombre;
	}

	public final RecepcionistaEntity setNombre(String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
		return this;
	}

	public final String getUsuario() {
		return usuario;
	}

	public final RecepcionistaEntity setUsuario(String usuario) {
		this.usuario = UtilText.getUtilText().applyTrim(usuario);
		return this;
	}

	public final String getConstraseña() {
		return constraseña;
	}

	public final RecepcionistaEntity setConstraseña(String constraseña) {
		this.constraseña = UtilText.getUtilText().applyTrim(constraseña);
		return this;
	}

	public final String getTelefono() {
		return telefono;
	}

	public final RecepcionistaEntity setTelefono(String telefono) {
		this.telefono = UtilText.getUtilText().applyTrim(telefono);
		return this;
	}

	public final int getSalario() {
		return salario;
	}

	public final RecepcionistaEntity setSalario(int salario) {
		this.salario = UtilNumber.getDefaultNumber();
		return this;
	}

	public final GimnasioEntity getGimnasioDTO() {
		return gimnasioEntity;
	}

	public final RecepcionistaEntity setGimnasioDTO(GimnasioEntity gimnasioEntity) {
		this.gimnasioEntity = UtilObject.getDefault(gimnasioEntity, GimnasioEntity.getDefaultObject());
		return this;
	}


}
