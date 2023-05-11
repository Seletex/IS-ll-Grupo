package co.edu.uco.transformate.crosscutting.exception;

public class TransformateApiException extends TransformateException {

	private static final long serialVersionUID = 2324985716431320544L;

	private TransformateApiException(final String technicalMessage, final String userMessage,
			final Throwable rootMessage) {
		super(technicalMessage, userMessage, rootMessage, ExceptionType.API);
		
	}

	public static TransformateApiException create(final String technicalMessage,
			final String userMessage,
			final Throwable rootMessage) {
		return new TransformateApiException(technicalMessage, userMessage, rootMessage);
	}

	public static TransformateApiException create(final String userMessage) {
		return new TransformateApiException(userMessage, userMessage, new Exception());
	}

	public static TransformateApiException create(final String technicalMessage, final String userMessage) {
		return new TransformateApiException(technicalMessage, userMessage, new Exception());
	}

}
