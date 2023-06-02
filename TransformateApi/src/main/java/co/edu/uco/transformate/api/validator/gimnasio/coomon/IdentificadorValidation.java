package co.edu.uco.transformate.api.validator.gimnasio.coomon;

import java.util.UUID;


import co.edu.uco.transformate.api.validator.Result;
import co.edu.uco.transformate.api.validator.Validation;
import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;
import co.edu.uco.transformate.crosscutting.utils.Messages.ValidationMessage;

public class IdentificadorValidation implements Validation<UUID>{

	private IdentificadorValidation() {
	
	}
	
	public static final Result validate(final UUID data) {
		return new IdentificadorValidation().execute(data);

	}
	
	@Override
	public Result execute(UUID data) {
		final var result = Result.create();
		if (UtilObject.isNull(data)) {
			result.addMessage(ValidationMessage.PROBLEM_WITH_TRANSACTION);
		} else if (UtilUUID.isDefaut(data)) {
			result.addMessage(ValidationMessage.PROBLEM_WITH_TRANSACTION);

		}
		return result;
	}

}
