package co.edu.uco.transformate.api.validator;

public interface Validation<T> {

	Result execute(T data);
}
