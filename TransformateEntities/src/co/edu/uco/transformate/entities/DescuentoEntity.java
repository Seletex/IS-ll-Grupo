package co.edu.uco.transformate.entities;



import java.util.UUID;


import co.edu.uco.transformate.crosscutting.utils.UtilNumber;
import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class DescuentoEntity {
	private UUID identificadorUuid;
	private short porcentaje;
	private TipoDescuentoEntity tipoDescuentoEntity;
	
	private static final DescuentoEntity DEFAULT_OBJECT = new DescuentoEntity();

	public static DescuentoEntity getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static DescuentoEntity create(UUID identificadorUuid, short porcentaje, TipoDescuentoEntity tipoDescuentoEntity) {
		return new DescuentoEntity(identificadorUuid,porcentaje,tipoDescuentoEntity);
	}

	public  DescuentoEntity(UUID identificadorUuid, short porcentaje, TipoDescuentoEntity tipoDescuentoEntity) {
	
		setIdentificadorUuid(identificadorUuid);
		setPorcentaje(porcentaje);
		setTipoDescuentoDTO(tipoDescuentoEntity);
	
	}

	private  DescuentoEntity() {
		setPorcentaje(UtilNumber.ZERO);
		setTipoDescuentoDTO(TipoDescuentoEntity.create());
		setIdentificadorUuid(UtilUUID.DEFAULT_UUID);
		
	}

	

	public final short getPorcentaje() {
		return porcentaje;
	}

	private final void setPorcentaje(short porcentaje) {
		this.porcentaje = (short) UtilNumber.getDefaultNumber(porcentaje);
	
	}

	public final TipoDescuentoEntity getTipoDescuentoDTO() {
		return tipoDescuentoEntity;
	}

	private final void setTipoDescuentoDTO(TipoDescuentoEntity tipoDescuentoEntity) {
		this.tipoDescuentoEntity = UtilObject.getDefault(tipoDescuentoEntity, TipoDescuentoEntity.create());
		
	}

	public final UUID getIdentificadorUuid() {
		return identificadorUuid;
	}

	private final void setIdentificadorUuid(UUID identificadorUuid) {
		this.identificadorUuid = UtilUUID.getDefault(identificadorUuid);
	
	}


	
	
	

}
