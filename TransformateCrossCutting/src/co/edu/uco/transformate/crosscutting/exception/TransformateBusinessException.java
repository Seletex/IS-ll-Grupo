package co.edu.uco.transformate.crosscutting.exception;

public class TransformateBusinessException extends TransformateException {

	private static final long serialVersionUID = 2324985716431320544L;

	private TransformateBusinessException(final String technicalMessage, final String userMessage,
			final Throwable rootMessage) {
		super(technicalMessage, userMessage, rootMessage, ExceptionType.BUSINESS);
		
	}

	public static TransformateBusinessException create(final String technicalMessage,
			final String userMessage,
			final Throwable rootMessage) {
		return new TransformateBusinessException(technicalMessage, userMessage, rootMessage);
	}

	public static TransformateBusinessException create(final String userMessage) {
		return new TransformateBusinessException(userMessage, userMessage, new Exception());
	}

	public static TransformateBusinessException create(final String technicalMessage, final String userMessage) {
		return new TransformateBusinessException(technicalMessage, userMessage, new Exception());
	}

}
