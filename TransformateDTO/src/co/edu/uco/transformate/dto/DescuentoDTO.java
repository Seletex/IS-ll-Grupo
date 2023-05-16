package co.edu.uco.transformate.dto;


import java.util.UUID;


import co.edu.uco.transformate.crosscutting.utils.UtilNumber;
import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

public class DescuentoDTO {
	private UUID identificadorUuid;
	private short porcentaje;
	private TipoDescuentoDTO tipoDescuentoDTO;
	
	

	public DescuentoDTO(UUID identificadorUuid, short porcentaje, TipoDescuentoDTO tipoDescuentoDTO) {
	
		setIdentificadorUuid(identificadorUuid);
		setPorcentaje(porcentaje);
		setTipoDescuentoDTO(tipoDescuentoDTO);
	
	}

	public DescuentoDTO() {
		setPorcentaje(UtilNumber.ZERO);
		setTipoDescuentoDTO(TipoDescuentoDTO.create());
		setIdentificadorUuid(UtilUUID.DEFAULT_UUID);
		
	}

	public static DescuentoDTO create() {
		return new DescuentoDTO();
	}

	public final short getPorcentaje() {
		return porcentaje;
	}

	public final DescuentoDTO setPorcentaje(short porcentaje) {
		this.porcentaje = (short) UtilNumber.getDefaultNumber(porcentaje);
		return this;
	}

	public final TipoDescuentoDTO getTipoDescuentoDTO() {
		return tipoDescuentoDTO;
	}

	public final DescuentoDTO setTipoDescuentoDTO(TipoDescuentoDTO tipoDescuentoDTO) {
		this.tipoDescuentoDTO = UtilObject.getDefault(tipoDescuentoDTO, TipoDescuentoDTO.create());
		return this;
	}

	public final UUID getIdentificadorUuid() {
		return identificadorUuid;
	}

	public final DescuentoDTO setIdentificadorUuid(UUID identificadorUuid) {
		this.identificadorUuid = UtilUUID.getDefault(identificadorUuid);
		return this;
	}


	
	
	

}
