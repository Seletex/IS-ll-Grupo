package co.edu.uco.transformate.dto;

import java.sql.Date;
import java.util.UUID;

public class EgresoDTO {
	
	private UUID identiUuid;
	private String nombreString;
	private String descripcionString;
	private int total;
	private Date fechaDate;
	private GerenteDTO responsableDto;
	private TipoEgresoDTO tipoEgresoDTO;

}
