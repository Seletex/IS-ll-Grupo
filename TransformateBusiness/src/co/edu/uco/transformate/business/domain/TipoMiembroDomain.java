package co.edu.uco.transformate.business.domain;


import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class TipoMiembroDomain {
	private UUID identificador;
	private String nombre;
	private TipoDescuentoDomain tipoDescuentoDomain;
	

	private static final TipoMiembroDomain DEFAULT_OBJECT = new TipoMiembroDomain();

	public static TipoMiembroDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static TipoMiembroDomain create(UUID identificadorUuid, String descripcion,TipoDescuentoDomain tipoDescuentoDomain
			) {
		return new TipoMiembroDomain(identificadorUuid,descripcion,tipoDescuentoDomain);
	}

	private TipoMiembroDomain(UUID identificador, String nombre, TipoDescuentoDomain tipoDescuentoDomain) {
		
		setIdentificador(identificador);
		setNombre(nombre);
		setTipoDescuentoDTO(tipoDescuentoDomain);

	}

	private TipoMiembroDomain() {
		
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setTipoDescuentoDTO(TipoDescuentoDomain.getDefaultObject());
		setNombre(UtilText.getDefaultValue());
		
	}

	public final TipoDescuentoDomain getTipoDescuentoDTO() {
		return tipoDescuentoDomain;
	}

	private final void setTipoDescuentoDTO(TipoDescuentoDomain tipoDescuentoDomain) {
		this.tipoDescuentoDomain = UtilObject.getDefault(tipoDescuentoDomain, TipoDescuentoDomain.getDefaultObject());
	
	}

	public static TipoMiembroDomain create() {
		return new TipoMiembroDomain();
	}

	public final UUID getIdentificador() {
		return identificador;
	}

	private final void setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
	
	}

	public final String getNombre() {
		return nombre;
	}

	private final void setNombre(String nombre) {
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
	
	}

}
