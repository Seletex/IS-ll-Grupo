package co.edu.uco.transformate.business.domain;



import java.util.UUID;


import co.edu.uco.transformate.crosscutting.utils.UtilNumber;
import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class DescuentoDomain {
	private UUID identificadorUuid;
	private short porcentaje;
	private TipoDescuentoDomain tipoDescuentoDomain;
	
	private static final DescuentoDomain DEFAULT_OBJECT = new DescuentoDomain();

	public static DescuentoDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static DescuentoDomain create(UUID identificadorUuid, short porcentaje, TipoDescuentoDomain tipoDescuentoDomain) {
		return new DescuentoDomain(identificadorUuid,porcentaje,tipoDescuentoDomain);
	}

	public  DescuentoDomain(UUID identificadorUuid, short porcentaje, TipoDescuentoDomain tipoDescuentoDomain) {
	
		setIdentificadorUuid(identificadorUuid);
		setPorcentaje(porcentaje);
		setTipoDescuentoDTO(tipoDescuentoDomain);
	
	}

	private  DescuentoDomain() {
		setPorcentaje(UtilNumber.ZERO);
		setTipoDescuentoDTO(TipoDescuentoDomain.create());
		setIdentificadorUuid(UtilUUID.DEFAULT_UUID);
		
	}

	

	public final short getPorcentaje() {
		return porcentaje;
	}

	private final void setPorcentaje(short porcentaje) {
		this.porcentaje = (short) UtilNumber.getDefaultNumber(porcentaje);
	
	}

	public final TipoDescuentoDomain getTipoDescuentoDTO() {
		return tipoDescuentoDomain;
	}

	private final void setTipoDescuentoDTO(TipoDescuentoDomain tipoDescuentoDomain) {
		this.tipoDescuentoDomain = UtilObject.getDefault(tipoDescuentoDomain, TipoDescuentoDomain.create());
		
	}

	public final UUID getIdentificadorUuid() {
		return identificadorUuid;
	}

	private final void setIdentificadorUuid(UUID identificadorUuid) {
		this.identificadorUuid = UtilUUID.getDefault(identificadorUuid);
	
	}


	
	
	

}
