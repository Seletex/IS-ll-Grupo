package co.edu.uco.transformate.dto;

import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class GimnasioDTO {
	
	private UUID identificador;
	private String nombre;
	private String descripcionString;
	private String telefonoString;
	private String correoString;
	public GimnasioDTO(UUID identificador, String nombre) {
		super();
		setIdentificador( identificador);
		setNombre(nombre);
	}
	
	 public GimnasioDTO() {
		 setIdentificador(UtilUUID.DEFAULT_UUID
				 );
		 setNombre(UtilText.getDefaultValue());
		
	}
	 
	 public static GimnasioDTO create() {
		 return new GimnasioDTO();
	 }

	public final UUID getIdentificador() {
		return identificador;
	}

	public final GimnasioDTO setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public final String getNombre() {
		return nombre;
	}

	public final GimnasioDTO setNombre(String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
		return this;
	}
	 
	 
		
	
	

}
