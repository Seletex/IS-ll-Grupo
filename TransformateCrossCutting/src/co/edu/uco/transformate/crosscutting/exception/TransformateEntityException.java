package co.edu.uco.transformate.crosscutting.exception;

public class TransformateEntityException extends TransformateException {

	private static final long serialVersionUID = 2324985716431320544L;

	private TransformateEntityException(final String technicalMessage, final String userMessage,
			final Throwable rootMessage) {
		super(technicalMessage, userMessage, rootMessage, ExceptionType.DTO);
		
	}

	public static TransformateEntityException create(final String technicalMessage,
			final String userMessage,
			final Throwable rootMessage) {
		return new TransformateEntityException(technicalMessage, userMessage, rootMessage);
	}

	public static TransformateEntityException create(final String userMessage) {
		return new TransformateEntityException(userMessage, userMessage, new Exception());
	}

	public static TransformateEntityException create(final String technicalMessage, final String userMessage) {
		return new TransformateEntityException(technicalMessage, userMessage, new Exception());
	}

}
