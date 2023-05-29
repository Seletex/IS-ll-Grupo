package co.edu.uco.transformate.crosscutting.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class UtilDate {

	public static final String DEFAULT_DATE_AS_STRING = "1970-01-01";
	public static final LocalDate DEFAULT_DATE = LocalDate.parse(DEFAULT_DATE_AS_STRING,
			DateTimeFormatter.ISO_LOCAL_DATE);
	private static final String DATE_RE_STRING = "\\d{4}-\\d{2}-\\d{2}";
	public static final LocalDateTime DEFAULT_DATE_TIME= LocalDateTime.now();
		
	
	private static final UtilDate INSTANCE = new UtilDate();



	public static final UtilDate getUtilDate() {
		return INSTANCE;
	}

	private UtilDate() {
	
	}

	public static final LocalDate generateNewDate() {
		return LocalDate.now();
	}

	public static final boolean dateStringIsValid(final String dateValue) {
		return (!UtilObject.isNull(dateValue) && dateValue.matches(DATE_RE_STRING));
	}

	public static final LocalDate genereteFechaFromString(final String fechaValue) {
		return (dateStringIsValid(fechaValue)) ? LocalDate.parse(fechaValue, DateTimeFormatter.ISO_LOCAL_DATE)
				: DEFAULT_DATE;
	}
	public static final LocalDateTime generateFechaFromStringTime(final String fechaValue) {
		return (dateStringIsValid(fechaValue)) ? LocalDateTime.parse(fechaValue, DateTimeFormatter.ISO_LOCAL_DATE)
				: DEFAULT_DATE_TIME;
	}

	public static final LocalDate getDefault(final LocalDate dateValue) {
		return (UtilObject.isNull(dateValue)) ? DEFAULT_DATE : dateValue;
	}
	public static final LocalDateTime getDefaultTime(final LocalDateTime dateValue) {
		return (UtilObject.isNull(dateValue)) ? DEFAULT_DATE_TIME : dateValue;
	}


	public final LocalDateTime isEmptyDateTime(final LocalDateTime dateValue) {
		return (UtilObject.isNull(dateValue)) ? DEFAULT_DATE_TIME : dateValue;
	}
	
	public  final LocalDate IsEmptyDate(final LocalDate dateValue) {
		return (UtilObject.isNull(dateValue)) ? DEFAULT_DATE : dateValue;
	}
}