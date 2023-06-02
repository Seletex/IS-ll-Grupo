package co.edu.uco.transformate.api.validator.entrenador.coomon;

import java.util.UUID;


import co.edu.uco.transformate.api.validator.Result;
import co.edu.uco.transformate.api.validator.Validation;
import co.edu.uco.transformate.crosscutting.utils.UtilObject;
import co.edu.uco.transformate.crosscutting.utils.UtilUUID;

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
			result.addMessage(
					"No es posible continuar con identificador del estado del tip relacion institucion vacio");
		} else if (UtilUUID.isDefaut(data)) {
			result.addMessage("No es posible tener el identificador por defecto del estado tipo relacion institucion");

		}
		return result;
	}

}
