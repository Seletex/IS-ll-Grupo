package co.edu.uco.transformate.api.validator.gimnasio.coomon;

import co.edu.uco.transformate.api.validator.Result;
import co.edu.uco.transformate.api.validator.Validation;
import co.edu.uco.transformate.crosscutting.utils.Messages.ValidationMessage;

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
			result.addMessage(ValidationMessage.PROBLEM_WITH_TRANSACTION);
		}
		if (true) {// validar solo puede contener letras y es pacios
			result.addMessage(ValidationMessage.PROBLEM_WITH_TRANSACTION);
		}
		result.addMessage(ValidationMessage.PROBLEM_WITH_TRANSACTION);

		return result;
	
	}
}
