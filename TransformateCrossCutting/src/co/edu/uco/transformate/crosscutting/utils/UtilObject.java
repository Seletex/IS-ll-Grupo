package co.edu.uco.transformate.crosscutting.utils;

public interface UtilObject {

	//private UtilObject() {
		//super();
	//}

	 static  <O> boolean isNull(final O object) {
		return object == null;
	}
<<<<<<< HEAD
	 
	 static <O> O getDefault(final O object, final O defaultValue) {
			return isNull(object) ? defaultValue : object;
		}

=======
>>>>>>> e59f9511753ae4554cd6904fbcb0b53a7f37dccc

}