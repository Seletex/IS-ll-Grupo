package co.edu.uco.transformate.crosscutting.utils;

import static co.edu.uco.transformate.crosscutting.utils.UtilObject.getDefault;

public class UtilNumber {
	
	public static final byte ZERO = 0;

	private UtilNumber() {
		super();

	}

	public static final <T extends Number> T getDefaultNumber(T value, T defaultValue) {
		return getDefault(value, defaultValue);
	}

	public static final <T extends Number> Number getDefaultNumber(T value) {
		return getDefault(value, ZERO);
	}

	public static final <T extends Number> boolean isGreaterThan(T numberOne, T numberTwo) {
		return getDefaultNumber(numberOne).doubleValue() > getDefaultNumber(numberTwo).doubleValue();
	}

	public static final <T extends Number> boolean isLessThan(T numberOne, T numberTwo) {
		return getDefaultNumber(numberOne).doubleValue() < getDefaultNumber(numberTwo).doubleValue();
	}

	public static final <T extends Number> boolean isEqualsThan(T numberOne, T numberTwo) {
		return getDefaultNumber(numberOne).doubleValue() == getDefaultNumber(numberTwo).doubleValue();
	}

	public static final <T extends Number> boolean isGreaterOrEqualsThan(T numberOne, T numberTwo) {
		return getDefaultNumber(numberOne).doubleValue() >= getDefaultNumber(numberTwo).doubleValue();
	}

	public static final <T extends Number> boolean isLessOrEqualsThan(T numberOne, T numberTwo) {
		return getDefaultNumber(numberOne).doubleValue() <= getDefaultNumber(numberTwo).doubleValue();
	}
	public static final <T extends Number> boolean isDifferentThan(T numberOne, T numberTwo) {
		return isEqualsThan(numberOne, numberTwo);
	}

	public static int getDefaultNumber(int value) {
		return (int) getDefault(value, ZERO);
	}
	
	public static boolean isEmpty(int value) {
		return UtilObject.isNull(value);
	}

	public static int getDefaultNumber() {
		return getDefaultNumber();
	}

	
}
