package co.edu.uco.transformate.dto;

import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilNumber;
import co.edu.uco.transformate.crosscutting.utils.UtilObject;

import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class EntrenadorDTO {
	
	private UUID identificador;
	private TipoDocumentoDTO tipoDocumentoDTO;
	private String identificacion;
	private String nombre;
	private String usuario;
	private String constraseña;
	private String telefono;
	private int salario;
	private GimnasioDTO gimnasioDTO;

	public EntrenadorDTO(final UUID identificador, final TipoDocumentoDTO tipoDocumentoDTO, final String identificacion,
			final String nombre, final String usuario, final String constraseña, final String telefono,
			final int salario, final GimnasioDTO gimnasioDTO) {
		super();
		setIdentificador(identificador);
		setTipoDocumentoDTO(tipoDocumentoDTO);
		setIdentificacion(identificacion);
		setNombre(nombre);
		setUsuario(usuario);
		setConstraseña(constraseña);
		setTelefono(telefono);
		setSalario(salario);
		setGimnasioDTO(gimnasioDTO);

	}

	public EntrenadorDTO() {
		super();
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setTipoDocumentoDTO(TipoDocumentoDTO.create());
		setNombre(UtilText.getDefaultValue());
		setIdentificacion(UtilText.EMPTY);
		setUsuario(UtilText.EMPTY);
		setConstraseña(UtilText.EMPTY);
		setTelefono(UtilText.EMPTY);
		setGimnasioDTO(GimnasioDTO.create());

	}

	public static EntrenadorDTO create() {
		return new EntrenadorDTO();
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	public final EntrenadorDTO setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		;
		return this;
	}

	public final TipoDocumentoDTO getTipoDocumentoDTO() {
		return tipoDocumentoDTO;
	}

	public final EntrenadorDTO setTipoDocumentoDTO(TipoDocumentoDTO tipoDocumentoDTO) {
		this.tipoDocumentoDTO = UtilObject.getDefault(tipoDocumentoDTO, TipoDocumentoDTO.create());
		return this;
	}

	public final String getIdentificacion() {
		return identificacion;
	}

	public final EntrenadorDTO setIdentificacion(String identificacion) {
		this.identificacion = UtilText.getUtilText().applyTrim(identificacion);
		return this;
	}

	public final String getNombre() {
		return nombre;
	}

	public final EntrenadorDTO setNombre(String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
		return this;
	}

	public final String getUsuario() {
		return usuario;
	}

	public final EntrenadorDTO setUsuario(String usuario) {
		this.usuario = UtilText.getUtilText().applyTrim(usuario);
		return this;
	}

	public final String getConstraseña() {
		return constraseña;
	}

	public final EntrenadorDTO setConstraseña(String constraseña) {
		this.constraseña = UtilText.getUtilText().applyTrim(constraseña);
		return this;
	}

	public final String getTelefono() {
		return telefono;
	}

	public final EntrenadorDTO setTelefono(String telefono) {
		this.telefono = UtilText.getUtilText().applyTrim(telefono);
		return this;
	}

	public final int getSalario() {
		return salario;
	}

	public final EntrenadorDTO setSalario(int salario) {
		this.salario = UtilNumber.getDefaultNumber();
		return this;
	}

	public final GimnasioDTO getGimnasioDTO() {
		return gimnasioDTO;
	}

	public final EntrenadorDTO setGimnasioDTO(GimnasioDTO gimnasioDTO) {
		this.gimnasioDTO = UtilObject.getDefault(gimnasioDTO, GimnasioDTO.create());
		return this;
	}

}
