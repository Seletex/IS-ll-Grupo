package co.edu.uco.transformate.api.validator.gimnasio.coomon;

import co.edu.uco.transformate.api.validator.Result;
import co.edu.uco.transformate.api.validator.Validation;

public class NombreValidation implements Validation<String> {
	private NombreValidation() {

	}

	public static final Result validate(final String data) {
		return new NombreValidation().execute(data);

	}

	@Override
	public Result execute(String data) {
		final var result = Result.create();

		if (data.length()<10) {// validar longitud de la cadena
			result.addMessage("No es posible tener el nombre por defecto del estado tipo relacion institucion");
		}
		if (true) {// validar solo puede contener letras y es pacios
			result.addMessage("No es posible tener el nombre por defecto del estado tipo relacion institucion");
		}
		result.addMessage("No es posible tener el nombre por defecto del estado tipo relacion institucion");

		return result;
	}
}
