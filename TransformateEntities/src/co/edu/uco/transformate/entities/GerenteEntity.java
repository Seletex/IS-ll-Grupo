package co.edu.uco.transformate.entities;

import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilNumber;
import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class GerenteEntity {
	
	private UUID identificador;
	private TipoDocumentoEntity tipoDocumentoEntity;
	private String identificacion;
	private String nombre;
	private String usuario;
	private String constraseña;
	private String telefono;
	private int salario;
	private GimnasioEntity gimnasioEntity;

	public GerenteEntity(final UUID identificador, final TipoDocumentoEntity tipoDocumentoEntity, final String identificacion,
			final String nombre, final String usuario, final String constraseña, final String telefono,
			final int salario, final GimnasioEntity gimnasioEntity) {
		super();
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

	public GerenteEntity() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setTipoDocumentoDTO(TipoDocumentoEntity.create());
		setNombre(UtilText.getDefaultValue());
		setIdentificacion(UtilText.EMPTY);
		setUsuario(UtilText.EMPTY);
		setConstraseña(UtilText.EMPTY);
		setTelefono(UtilText.EMPTY);
		setGimnasioDTO(GimnasioEntity.create());

	}

	public static GerenteEntity create() {
		return new GerenteEntity();
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	public final GerenteEntity setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		;
		return this;
	}

	public final TipoDocumentoEntity getTipoDocumentoDTO() {
		return tipoDocumentoEntity;
	}

	public final GerenteEntity setTipoDocumentoDTO(TipoDocumentoEntity tipoDocumentoEntity) {
		this.tipoDocumentoEntity = UtilObject.getDefault(tipoDocumentoEntity, TipoDocumentoEntity.create());
		return this;
	}

	public final String getIdentificacion() {
		return identificacion;
	}

	public final GerenteEntity setIdentificacion(String identificacion) {
		this.identificacion = UtilText.getUtilText().applyTrim(identificacion);
		return this;
	}

	public final String getNombre() {
		return nombre;
	}

	public final GerenteEntity setNombre(String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
		return this;
	}

	public final String getUsuario() {
		return usuario;
	}

	public final GerenteEntity setUsuario(String usuario) {
		this.usuario = UtilText.getUtilText().applyTrim(usuario);
		return this;
	}

	public final String getConstraseña() {
		return constraseña;
	}

	public final GerenteEntity setConstraseña(String constraseña) {
		this.constraseña = UtilText.getUtilText().applyTrim(constraseña);
		return this;
	}

	public final String getTelefono() {
		return telefono;
	}

	public final GerenteEntity setTelefono(String telefono) {
		this.telefono = UtilText.getUtilText().applyTrim(telefono);
		return this;
	}

	public final int getSalario() {
		return salario;
	}

	public final GerenteEntity setSalario(int salario) {
		this.salario = UtilNumber.getDefaultNumber();
		return this;
	}

	public final GimnasioEntity getGimnasioDTO() {
		return gimnasioEntity;
	}

	public final GerenteEntity setGimnasioDTO(GimnasioEntity gimnasioEntity) {
		this.gimnasioEntity = UtilObject.getDefault(gimnasioEntity, GimnasioEntity.create());
		return this;
	}

}
