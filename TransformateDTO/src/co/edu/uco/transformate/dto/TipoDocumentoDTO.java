package co.edu.uco.transformate.dto;

<<<<<<< HEAD
import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilText;

import co.edu.uco.transformate.crosscutting.utils.*;

public class TipoDocumentoDTO {

	private UUID identificador;
	private String nombre;
	public TipoDocumentoDTO(UUID identificador, String nombre) {
		super();
		setIdentificador( identificador);
		setNombre(nombre);
	}
	
	 public TipoDocumentoDTO() {
		 setIdentificador(UtilUUID.DEFAULT_UUID
				 );
		 setNombre(UtilText.getDefaultValue());
		
	}
	 
	 public static TipoDocumentoDTO create() {
		 return new TipoDocumentoDTO();
	 }

	public final UUID getIdentificador() {
		return identificador;
	}

	public final TipoDocumentoDTO setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public final String getNombre() {
		return nombre;
	}

	public final TipoDocumentoDTO setNombre(String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
		return this;
	}
	 
	 
		
	
	
	

=======
public class TipoDocumentoDTO {

>>>>>>> e59f9511753ae4554cd6904fbcb0b53a7f37dccc
}
