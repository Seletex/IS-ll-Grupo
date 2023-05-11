package co.edu.uco.transformate.crosscutting.exception;

public class TransformateDataException extends TransformateException {

	private static final long serialVersionUID = 2324985716431320544L;

	private TransformateDataException(final String technicalMessage, final String userMessage,
			final Throwable rootMessage) {
		super(technicalMessage, userMessage, rootMessage, ExceptionType.DATA);
		
	}

	public static TransformateDataException create(final String technicalMessage,
			final String userMessage,
			final Throwable rootMessage) {
		return new TransformateDataException(technicalMessage, userMessage, rootMessage);
	}

	public static TransformateDataException create(final String userMessage) {
		return new TransformateDataException(userMessage, userMessage, new Exception());
	}

	public static TransformateDataException create(final String technicalMessage, final String userMessage) {
		return new TransformateDataException(technicalMessage, userMessage, new Exception());
	}

}
