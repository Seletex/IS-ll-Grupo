package co.edu.uco.transformate.api.validator.entrenador.coomon;

import co.edu.uco.transformate.api.validator.Result;
import co.edu.uco.transformate.api.validator.Validation;

public class CorreoValidation implements Validation<String> {

	private CorreoValidation() {
	
	}

	public static final Result validate(final String data) {
		return new CorreoValidation().execute(data);

	}

	@Override
	public Result execute(String data) {
		
		var result = Result.create();

		if (data.length()<50) {// validar longitud de la cadena
			result.addMessage("No es posible tener el corre por defecto por favor escriba algo diferente");
		}
		if (true) {// validar solo puede contener letras y es pacios
			result.addMessage("No es posible tener el nombre por defecto del estado tipo relacion institucion");
		}
		result.addMessage("No es posible tener el nombre por defecto del estado tipo relacion institucion");

		return result;
	
	}
}
