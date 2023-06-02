package co.edu.uco.transformate.api.validator.gimnasio;



import co.edu.uco.transformate.api.validator.Result;
import co.edu.uco.transformate.api.validator.Validation;
import co.edu.uco.transformate.api.validator.gimnasio.coomon.NombreValidation;
import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.dto.GimnasioDTO;

public class RegistrarGimnasioValidation implements Validation<GimnasioDTO>{

	private RegistrarGimnasioValidation() {
		
	}

	public static final Result validate(final GimnasioDTO data) {
		return new RegistrarGimnasioValidation().execute(data);

	}
	
	@Override
	public Result execute(GimnasioDTO data) {
final var result = Result.create();
		
		if(UtilObject.isNull(data)) {
			result.addMessage("No es posible registrar un nuev tipo de estado tipo relacion institucion con los datos vacios");
		}else {
			result.addMessages(NombreValidation.validate(data.getNombre()).getMessages());
			result.addMessages(NombreValidation.validate(data.getDescripcionString()).getMessages());
			result.addMessages(NombreValidation.validate(data.getCorreoString()).getMessages());
			result.addMessages(NombreValidation.validate(data.getTelefonoString()).getMessages());
		}
		
		
		return result;
	}

}
