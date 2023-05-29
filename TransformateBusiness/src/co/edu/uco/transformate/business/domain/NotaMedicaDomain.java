package co.edu.uco.transformate.business.domain;


import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class NotaMedicaDomain {
	
	private UUID identificador;
	private MiembroDomain miembroDomain;
	private String descripcion;
	

	private static final NotaMedicaDomain DEFAULT_OBJECT = new NotaMedicaDomain();

	public static NotaMedicaDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static NotaMedicaDomain create(UUID identificador, String nombre,MiembroDomain miembroDomain
			) {
		return new NotaMedicaDomain(identificador,nombre,miembroDomain);
	}
	
	public NotaMedicaDomain(UUID identificador, String nombre,MiembroDomain miembroDomain) {


		setIdentificador(identificador);
		setDescripcion(nombre);
		setMiembroDTO(miembroDomain);

	}

	private NotaMedicaDomain() {
		
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setMiembroDTO(MiembroDomain.getDefaultObject());
		setDescripcion(UtilText.getDefaultValue());
		
	}



	public final UUID getIdentificador() {
		return identificador;
	}

	public final NotaMedicaDomain setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		return this;
	}

	public final String getDescripcion() {
		return descripcion;
	}

	public final NotaMedicaDomain setDescripcion(String nombre) {
		this.descripcion = UtilText.getUtilText().applyTrim(nombre);
		return this;
	}

	public MiembroDomain getMiembroDTO() {
		return miembroDomain;
	}

	public NotaMedicaDomain setMiembroDTO(MiembroDomain miembroDomain) {
		this.miembroDomain = UtilObject.getDefault(miembroDomain,MiembroDomain.getDefaultObject());return this;
	}

}
