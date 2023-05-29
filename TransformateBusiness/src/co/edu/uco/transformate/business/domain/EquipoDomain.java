package co.edu.uco.transformate.business.domain;

import java.util.UUID;

import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilText;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class EquipoDomain {

	private UUID identificador;
	private String nombre;
	private String descripcion;
	private ZonaDomain zonaDomain;

	private static final EquipoDomain DEFAULT_OBJECT = new EquipoDomain();

	public static EquipoDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static EquipoDomain create(UUID identificador, String nombre, String descripcion, ZonaDomain zonaDomain) {
		return new EquipoDomain(identificador,nombre,descripcion,zonaDomain);
	}
	
	public  EquipoDomain(UUID identificador, String nombre, String descripcion, ZonaDomain zonaDomain) {
	
		setIdentificador(identificador);
		setNombre(nombre);
		setDescripcion(descripcion);
		setZonaDTO(zonaDomain);

	}



	private EquipoDomain() {
	
		setIdentificador(UtilUUID.DEFAULT_UUID);
		setZonaDTO(ZonaDomain.getDefaultObject());
		setNombre(UtilText.getDefaultValue());
		setDescripcion(UtilText.EMPTY);
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

	public final String getDescripcion() {
		return descripcion;
	}

	private final void setDescripcion(String descripcion) {
		this.descripcion = UtilText.getUtilText().applyTrim(descripcion);
		
	}

	public final ZonaDomain getZonaDTO() {
		return zonaDomain;
	}

	private final void setZonaDTO(ZonaDomain zonaDomain) {
		this.zonaDomain =  UtilObject.getDefault(zonaDomain, ZonaDomain.getDefaultObject());
		
	}

}
