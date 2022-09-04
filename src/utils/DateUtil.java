package utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
	
	public static final String DATE_PATTERN = "dd/MM/yyyy";
	
	public static Date stringToDate(String value) {
		
		String[] date = value.split("/");
		Calendar calendar = Calendar.getInstance();
		calendar.set(
				Integer.parseInt(date[2]),
				Integer.parseInt(date[1]), 
				Integer.parseInt(date[0])
				);
		
		return calendar.getTime();
	}

	public static String DateToString(Date date) {
		return new SimpleDateFormat(
				DATE_PATTERN, 
				new Locale("pt", "br")).format(date);
		
	}
}
