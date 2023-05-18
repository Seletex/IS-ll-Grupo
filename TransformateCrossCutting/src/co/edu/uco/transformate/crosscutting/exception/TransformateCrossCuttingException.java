package co.edu.uco.transformate.crosscutting.exception;

public class TransformateCrossCuttingException extends TransformateException {

	private static final long serialVersionUID = 2324985716431320544L;

	private TransformateCrossCuttingException(final String technicalMessage, final String userMessage,
			final Throwable rootMessage) {
		super(technicalMessage, userMessage, rootMessage, ExceptionType.CROSSCUTTING);
		
	}

	public static TransformateCrossCuttingException create(final String technicalMessage,
			final String userMessage,
			final Throwable rootMessage) {
		return new TransformateCrossCuttingException(technicalMessage, userMessage, rootMessage);
	}

	public static TransformateCrossCuttingException create(final String userMessage) {
		return new TransformateCrossCuttingException(userMessage, userMessage, new Exception());
	}

	public static TransformateCrossCuttingException create(final String technicalMessage, final String userMessage) {
		return new TransformateCrossCuttingException(technicalMessage, userMessage, new Exception());
	}

	public static Exception createTechnicalException(String technicalTryInitTransaction) {
	
		return null;
	}

}
