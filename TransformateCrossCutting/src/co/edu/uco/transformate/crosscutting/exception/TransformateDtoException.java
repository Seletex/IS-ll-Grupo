package co.edu.uco.transformate.crosscutting.exception;

public class TransformateDtoException extends TransformateException {

	private static final long serialVersionUID = 2324985716431320544L;

	private TransformateDtoException(final String technicalMessage, final String userMessage,
			final Throwable rootMessage) {
		super(technicalMessage, userMessage, rootMessage, ExceptionType.ENTITY);
		
	}

	public static TransformateDtoException create(final String technicalMessage,
			final String userMessage,
			final Throwable rootMessage) {
		return new TransformateDtoException(technicalMessage, userMessage, rootMessage);
	}

	public static TransformateDtoException create(final String userMessage) {
		return new TransformateDtoException(userMessage, userMessage, new Exception());
	}

	public static TransformateDtoException create(final String technicalMessage, final String userMessage) {
		return new TransformateDtoException(technicalMessage, userMessage, new Exception());
	}

}
