package co.edu.uco.transformate.api.validator.gimnasio.coomon;

import co.edu.uco.transformate.api.validator.Result;
import co.edu.uco.transformate.api.validator.Validation;
import co.edu.uco.transformate.crosscutting.utils.Messages.ValidationMessage;

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
			result.addMessage(ValidationMessage.PROBLEM_WITH_TRANSACTION);
		}
		if (true) {// validar solo puede contener letras y es pacios
			result.addMessage(ValidationMessage.PROBLEM_WITH_TRANSACTION);
		}
		result.addMessage(ValidationMessage.PROBLEM_WITH_TRANSACTION);

		return result;
	}

}
