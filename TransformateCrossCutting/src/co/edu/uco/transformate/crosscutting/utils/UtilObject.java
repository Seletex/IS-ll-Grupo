package co.edu.uco.transformate.crosscutting.utils;

public interface UtilObject {

	//private UtilObject() {
		//super();
	//}

	 static  <O> boolean isNull(final O object) {
		return object == null;
	}

}