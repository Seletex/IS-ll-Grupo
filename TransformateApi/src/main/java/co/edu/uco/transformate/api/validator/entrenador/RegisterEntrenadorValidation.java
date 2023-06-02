package co.edu.uco.transformate.api.validator.entrenador;

import co.edu.uco.transformate.api.validator.Result;
import co.edu.uco.transformate.api.validator.Validation;

import co.edu.uco.transformate.api.validator.gimnasio.coomon.NombreValidation;
import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.dto.EntrenadorDTO;


public class RegisterEntrenadorValidation implements Validation<EntrenadorDTO>{

	private RegisterEntrenadorValidation() {
		
	}

	public static final Result validate(final EntrenadorDTO data) {
		return new RegisterEntrenadorValidation().execute(data);

	}
	
	@Override
	public Result execute(EntrenadorDTO data) {
final var result = Result.create();
		
		if(UtilObject.isNull(data)) {
			result.addMessage("No es posible registrar un nuev tipo de estado tipo relacion institucion con los datos vacios");
		}else {
			result.addMessages(NombreValidation.validate(data.getIdentificacion()).getMessages());
			result.addMessages(NombreValidation.validate(data.getNombre()).getMessages());
			
			result.addMessages(NombreValidation.validate(data.getUsuario()).getMessages());
			result.addMessages(NombreValidation.validate(data.getConstraseña()).getMessages());
			result.addMessages(NombreValidation.validate(data.getTelefono()).getMessages());
			

		}
		
		
		return result;
	}
}
