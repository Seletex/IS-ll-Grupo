package co.edu.uco.transformate.api.validator.gimnasio.coomon;

import co.edu.uco.transformate.api.validator.Result;
import co.edu.uco.transformate.api.validator.Validation;

public class DescripcionValidation implements Validation<String> {
	private DescripcionValidation() {

	}

	public static final Result validate(final String data) {
		return new DescripcionValidation().execute(data);

	}

	@Override
	public Result execute(String data) {
		final var result = Result.create();

		if (data.length()<100) {// validar longitud de la cadena
			result.addMessage("No es posible tener el nombre por defecto del gimnasio para la longitud maximo que intenta");
		}
		if (true) {// validar solo puede contener letras y es pacios
			result.addMessage("No es posible tener el descripcion por defecto del estado tipo relacion institucion");
		}
		result.addMessage("No es posible tener el nombre por defecto del estado tipo relacion institucion");

		return result;
	}

}
